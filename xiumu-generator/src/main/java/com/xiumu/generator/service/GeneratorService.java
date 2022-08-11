package com.xiumu.generator.service;

import cn.hutool.core.bean.BeanUtil;
import com.xiumu.generator.VelocityUtil;
import com.xiumu.generator.constants.Constants;
import com.xiumu.generator.entity.GenTable;
import com.xiumu.generator.entity.GenTableColumn;
import com.xiumu.generator.entity.GeneratorBO;
import com.xiumu.generator.mapper.CodeTemplateMapper;
import com.xiumu.generator.mapper.DatabaseMapper;
import com.xiumu.generator.mapper.GenTableColumnMapper;
import com.xiumu.generator.mapper.GenTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 生成某个表的代码
     *
     * @param generatorBO 配置信息
     */
    public void createCode(GeneratorBO generatorBO) throws Exception {
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
        int count = genTableMapper.countTableByName(Constants.CODE_TEMPLATE_TABLE);
        count = genTableMapper.countTableByName(Constants.CODE_TEMPLATE_TABLE.toUpperCase(Locale.ROOT));
        if (count < 1) {
            codeTemplateMapper.createCodeTemplate();
        }
        count = genTableMapper.countTableByName(Constants.DATABASE_TABLE);
        count = genTableMapper.countTableByName(Constants.DATABASE_TABLE.toUpperCase(Locale.ROOT));
        if (count < 1) {
            databaseMapper.createDatabase();
        }
    }
}
