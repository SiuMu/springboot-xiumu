package com.xiumu.springbootxiumu.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xiumu.springbootxiumu.pojo.base.BaseEntity;
import lombok.Data;

/**
 * 用户角色关联表
 * @author xiumu
 */
@Data
@TableName("sys_user_role")
public class UserRole extends BaseEntity {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 角色ID
     */
    private String roleId;
}