package com.xiumu.springbootxiumu.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xiumu.springbootxiumu.pojo.base.BaseEntity;
import lombok.Data;

/**
 * 角色权限关联表
 *
 * @author xiumu
 */
@Data
@TableName("sys_role_auth")
public class RoleAuth extends BaseEntity {

    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 权限ID
     */
    private Long authId;

    public RoleAuth() {
    }

    public RoleAuth(Long roleId, Long authId) {
        this.roleId = roleId;
        this.authId = authId;
    }
}
