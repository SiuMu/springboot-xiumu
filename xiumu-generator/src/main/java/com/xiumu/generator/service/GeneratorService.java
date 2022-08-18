package com.xiumu.generator.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiumu.generator.VelocityUtil;
import com.xiumu.generator.constants.Constants;
import com.xiumu.generator.entity.*;
import com.xiumu.generator.enums.Language;
import com.xiumu.generator.mapper.CodeTemplateMapper;
import com.xiumu.generator.mapper.DatabaseMapper;
import com.xiumu.generator.mapper.GenTableColumnMapper;
import com.xiumu.generator.mapper.GenTableMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class GeneratorService {

    @Autowired
    private GenTableMapper genTableMapper;

    @Autowired
    private GenTableColumnMapper columnMapper;

    @Autowired
    private CodeTemplateMapper codeTemplateMapper;

    @Autowired
    private DatabaseMapper databaseMapper;

    @Autowired
    private DefaultDataSourceCreator dataSourceCreator;

    @Autowired(required = false)
    private DynamicRoutingDataSource dynamicRoutingDataSource;

    /**
     * 生成某个表的代码
     *
     * @param generatorBO 配置信息
     */
    public void createCode(GeneratorBO generatorBO) {
        // 获取表的每一列信息
        List<GenTableColumn> tableColumns = columnMapper.selectTableColumnByName(generatorBO.getTableName(), generatorBO.getDatabaseName());
        // 去除需要忽略生成的字段。例如，id, createTime, updateTime 等字段需要继承父类，无需生成
        tableColumns.removeIf(item -> Constants.IGNORE_COLUMN.contains(item.getColumnName()));
        // 获取表信息
        GenTable table = genTableMapper.selectGenTableByName(generatorBO.getTableName(), generatorBO.getDatabaseName());
        BeanUtil.copyProperties(generatorBO.getConfig(), table);
        VelocityUtil.createCode(table, tableColumns);
    }

    /**
     * 生成某些表的代码
     *
     * @param generatorBOList 配置信息
     */
    public void createCode(List<GeneratorBO> generatorBOList) throws Exception {
        for (GeneratorBO generatorBO : generatorBOList) {
            createCode(generatorBO);
        }
    }

    /**
     * 生成某些表的代码
     *
     * @param config 配置信息
     */
    public List<CodeResult> createCode(CodeConfig config){
        // 生成数据源
        // 初始化Velocity
        // 设置变量 VelocityContext
        // 生成代码结果，
        List<CodeTemplate> templateList = new ArrayList<>();
        List<TemplateConfig> templateConfigList = config.getTemplateConfigList();
        for (TemplateConfig templateConfig : templateConfigList) {
            CodeTemplate codeTemplate = codeTemplateMapper.selectByTemplateName(templateConfig.getTemplateName());
            templateList.add(codeTemplate);
        }
        Database database = databaseMapper.selectById(config.getDbId());
        this.addDatasource(database);
        DynamicDataSourceContextHolder.push(database.getDataSource());
        System.out.println(DynamicDataSourceContextHolder.peek());
        // 查询表信息
        GenTable table = genTableMapper.selectGenTableByName(config.getTableName(), database.getDatabaseName());
        List<GenTableColumn> columns = columnMapper.selectTableColumnByName(config.getTableName(), database.getDatabaseName());
        Velocity.init();
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("tableName", table.getTableName());
        velocityContext.put("ClassName", config.getClassName());
        velocityContext.put("className", StringUtils.uncapitalize(config.getClassName()));
        velocityContext.put("entityPackageName", config.getEntityPackageName());
        velocityContext.put("servicePackageName", config.getServicePackageName());
        velocityContext.put("controllerPackageName", config.getControllerPackageName());
        velocityContext.put("author", config.getAuthor());
        velocityContext.put("datetime", DateUtil.now());
        velocityContext.put("columns", columns);
        StringWriter stringWriter = new StringWriter();
        Velocity.evaluate(velocityContext, stringWriter, templateList.get(0).getTemplateName(), templateList.get(0).getTemplateContent());
        CodeResult codeResult = new CodeResult()
                .setTemplateName(config.getTemplateConfigList().get(0).getTemplateName())
                .setCodeContent(stringWriter.toString());
        DynamicDataSourceContextHolder.clear();
        List<CodeResult> results = new ArrayList<>();
        results.add(codeResult);
        return results;
    }

    /**
     * 初始化操作
     */
    public void init() {
        // 验证数据库中是否有 以下两个表结构，如果没有就创建
        int count = genTableMapper.countTableByName(Constants.CODE_TEMPLATE_TABLE.toUpperCase(Locale.ROOT));
        if (count < 1) {
            codeTemplateMapper.createCodeTemplate();
        }
        count = genTableMapper.countTableByName(Constants.DATABASE_TABLE.toUpperCase(Locale.ROOT));
        if (count < 1) {
            databaseMapper.createDatabase();
        }
        // 初始化固定模板
        // 获取模板内容
        // 获取 vm 文件夹所在绝对路径
        String vmPath = "";
        try {
            vmPath = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+"vm").getPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取 vm 文件夹下面所有的文件名
        String[] templateNames = new File(vmPath).list();
        System.out.println(Arrays.asList(templateNames));
        // 将模板信息保存到数据库
        if (templateNames != null){
            for (String templateName : templateNames) {
                if (templateName.contains("txt")){
                    codeTemplateMapper.delete(new LambdaQueryWrapper<CodeTemplate>().eq(CodeTemplate::getTemplateName, templateName.replace(".txt","")));
                    String content = FileUtil.readString(vmPath + File.separatorChar + templateName, Charset.defaultCharset());
                    codeTemplateMapper.insert(new CodeTemplate(templateName.replace(".txt",""),content, Language.JAVA));
                }
            }
        }
    }

    /**
     * 动态添加一个数据源
     *
     * @param database 数据源
     */
    public void addDatasource(Database database) {
        DataSourceProperty property = new DataSourceProperty()
                .setDriverClassName(database.getDatabaseType().getDriverClassName())
                .setUrl(database.getDatabaseType().getUrlPrefix() + database.getIpPort() + database.getDatabaseName() + database.getDatabaseType().getUrlSuffix())
                .setUsername(database.getUsername())
                .setPassword(database.getPassword());
        System.out.println("添加数据源：" + property.getUrl());
        DataSource dataSource = dataSourceCreator.createDataSource(property);
        dynamicRoutingDataSource.addDataSource(database.getIpPort() + database.getDatabaseName(), dataSource);
    }
}
