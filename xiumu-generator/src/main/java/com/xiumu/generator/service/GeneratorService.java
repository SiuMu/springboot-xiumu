package com.xiumu.generator.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.FileUtil;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiumu.generator.VelocityUtil;
import com.xiumu.generator.constants.Constants;
import com.xiumu.generator.entity.*;
import com.xiumu.generator.enums.Language;
import com.xiumu.generator.mapper.CodeTemplateMapper;
import com.xiumu.generator.mapper.DatabaseMapper;
import com.xiumu.generator.mapper.GenTableColumnMapper;
import com.xiumu.generator.mapper.GenTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
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
