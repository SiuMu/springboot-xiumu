package com.xiumu.generator.entity;

import lombok.Data;

import java.util.List;

/**
 * 表的详细信息，包括字段
 */
@Data
public class GenTableDO {

    /**
     * 表信息
     */
    GenTable genTable;

    /**
     * 字段信息
     */
    List<GenTableColumn> columnList;

    public GenTableDO() {
    }

    public GenTableDO(GenTable genTable, List<GenTableColumn> columnList) {
        this.genTable = genTable;
        this.columnList = columnList;
    }
}
