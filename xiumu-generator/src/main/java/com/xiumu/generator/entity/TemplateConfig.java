package com.xiumu.generator.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 代码生成器的模板配置
 *
 **/
@Data
@Accessors(chain = true)
public class TemplateConfig {

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 生成文件名
     */
    private String fileName;

}
