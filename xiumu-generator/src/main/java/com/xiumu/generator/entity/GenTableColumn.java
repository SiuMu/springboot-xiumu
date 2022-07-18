package com.xiumu.generator.entity;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 表中每一列的详细信息
 *
 * @Author XiuMu
 * @Date 2022/7/16
 **/
@Data
@Accessors(chain = true)
@TableName("information_schema.COLUMNS")
public class GenTableColumn {

    /**
     * 列名称
     */
    private String columnName;

    /**
     * 列描述
     */
    private String columnComment;

    /**
     * 列类型
     */
    private String dataType;

    /**
     * 是否为空
     */
    private String isNullable;

    /**
     * JAVA类型
     */
    private String javaType;

    /**
     * JAVA字段名
     */
    private String javaField;

    public void setColumnName(String columnName) {
        this.columnName = columnName;
        this.javaField = StrUtil.toCamelCase(columnName);
    }


    public void setDataType(String dataType) {
        this.dataType = dataType;
        switch (dataType) {
            case "tinyint":
            case "int":
                this.javaType = "Integer";
                break;
            case "datetime":
                this.javaType = "Date";
                break;
            case "bigint":
                this.javaType = "Long";
                break;
            case "double":
            case "float":
            case "decimal":
                this.javaType = "BigDecimal";
                break;
            default:
                this.javaType = "String";
        }
    }
}
