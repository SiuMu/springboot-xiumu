package com.xiumu.common.core.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.xiumu.enums.YesNo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类必要字段
 *
 * @Author XiuMu
 * @Date 2022/7/16
 **/
@Data
public class BaseEntity implements Serializable {

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
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;


    /**
     * 是否删除，0否，1是
     */
    private YesNo deleteFlag;
}