package com.xiumu.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xiumu.generator.enums.Language;
import lombok.Data;

import java.util.Date;

/**
 * 代码生成器的模板
 *
 * @Author XiuMu
 * @Date 2022/8/11
 **/
@Data
@TableName("xiumu_code_template")
public class CodeTemplate {

    /**
     * 主键
     * 提示：使用 Long 传递给前端会出现精度丢失问题
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 模板内容
     */
    private String templateContent;

    /**
     * 开发语言
     */
    private Language language;
}
