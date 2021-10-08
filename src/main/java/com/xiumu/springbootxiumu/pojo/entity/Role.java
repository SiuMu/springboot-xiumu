package com.xiumu.springbootxiumu.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xiumu.springbootxiumu.pojo.base.BaseEntity;
import lombok.Data;

/**
 * 角色表
 */
@TableName("sys_role")
@Data
public class Role extends BaseEntity {

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色编码
     */
    private String code;


}
