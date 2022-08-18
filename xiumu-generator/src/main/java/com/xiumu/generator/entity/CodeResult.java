package com.xiumu.generator.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 生成结果
 */
@Data
@Accessors(chain = true)
public class CodeResult {

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 生成的代码内容
     */
    private String codeContent;
}
