package com.xiumu.generator.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.xiumu.common.core.utils.AssertUtil;
import com.xiumu.generator.VelocityUtil;
import com.xiumu.generator.constants.Constants;
import com.xiumu.generator.entity.GenTable;
import com.xiumu.generator.entity.GenTableColumn;
import com.xiumu.generator.entity.GeneratorBO;
import com.xiumu.generator.exception.GenException;
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
     * @param generatorBO 配置信息
     */
    @DS(Constants.DS)
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
        // 验证数据库中是否有 xiumu 表结构
        Integer count = genTableMapper.countTableByName(Constants.MY_TABLE);
        // 如果未创建 就先创建该数据库
        if (count > 0) {

        }
        AssertUtil.isTrue(count > 0, GenException.NOT_EXIT_MY_TABLE);

    }
}
