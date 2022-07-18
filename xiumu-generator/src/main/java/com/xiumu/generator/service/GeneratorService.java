package com.xiumu.generator.service;

import cn.hutool.core.bean.BeanUtil;
import com.xiumu.generator.VelocityUtil;
import com.xiumu.generator.config.GeneratorConfig;
import com.xiumu.generator.constants.Constants;
import com.xiumu.generator.entity.GenTable;
import com.xiumu.generator.entity.GenTableColumn;
import com.xiumu.generator.mapper.GenTableColumnMapper;
import com.xiumu.generator.mapper.GenTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneratorService {

    @Autowired
    private GenTableMapper genTableMapper;

    @Autowired
    private GenTableColumnMapper columnMapper;


    /**
     * 生成某个表的代码
     *
     * @param databaseName 数据库名
     * @param tableName    表名
     * @param config       配置信息
     */
    public void createCode(String databaseName, String tableName, GeneratorConfig config) throws Exception {
        // 获取表的每一列信息
        List<GenTableColumn> tableColumns = columnMapper.selectTableColumnByName(tableName, databaseName);
        // 去除需要忽略生成的字段。例如，id, createTime, updateTime 等字段需要继承父类，无需生成
        tableColumns.removeIf(item -> Constants.IGNORE_COLUMN.contains(item.getColumnName()));
        // 获取表信息
        GenTable table = genTableMapper.selectGenTableByName(tableName, databaseName);
        BeanUtil.copyProperties(config, table);
        VelocityUtil.createCode(table, tableColumns);
    }

}
