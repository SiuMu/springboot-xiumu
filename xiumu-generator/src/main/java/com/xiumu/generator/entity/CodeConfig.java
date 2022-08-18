package com.xiumu.generator.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 生成配置
 *
 * @Author XiuMu
 * @Date 2022/7/16
 **/
@Data
@Accessors(chain = true)
public class CodeConfig {

    /**
     * 数据源ID
     */
    @NotBlank(message = "数据源不能为空")
    private String dbId;

    /**
     * 表名
     */
    @NotBlank(message = "表名不能为空")
    private String tableName;

    /**
     * 生成作者
     */
    @NotBlank(message = "作者不能为空")
    private String author;

    /**
     * 实体类名称(首字母大写)
     */
    @NotBlank(message = "类名不能为空")
    private String className;

    /**
     * 生成实体类包路径，
     */
    @NotBlank(message = "实体类包路径不能为空")
    private String entityPackageName;

    /**
     * 生成 dao 与 service 包路径，
     */
    @NotBlank(message = "service包路径不能为空")
    private String servicePackageName;

    /**
     * 生成 controller 包路径，
     */
    @NotBlank(message = "controller 包路径不能为空")
    private String controllerPackageName;

    /**
     * 生成模板
     */
    private List<TemplateConfig> templateConfigList;
}
