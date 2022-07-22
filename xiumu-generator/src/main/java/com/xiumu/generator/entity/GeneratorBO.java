package com.xiumu.generator.entity;

import com.xiumu.generator.config.GeneratorConfig;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 生成代码 传参
 *
 * @Author XiuMu
 * @Date 2022/7/23
 */
@Data
@Accessors(chain = true)
public class GeneratorBO {
    /**
     * 数据库名称
     */
    private String databaseName;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 配置
     */
    private GeneratorConfig config;

    public GeneratorBO() {
    }

    public GeneratorBO(String databaseName, String tableName, GeneratorConfig config) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.config = config;
    }
}
