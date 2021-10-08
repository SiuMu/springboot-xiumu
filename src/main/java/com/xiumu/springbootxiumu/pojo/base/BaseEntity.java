package com.xiumu.springbootxiumu.pojo.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.xiumu.springbootxiumu.utils.enums.YesNo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体必要字段
 *
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;


    /**
     * 更新时间
     */
    private Date updateTime;


    /**
     * 是否删除，0否，1是
     */
    private YesNo deleteFlag;

}