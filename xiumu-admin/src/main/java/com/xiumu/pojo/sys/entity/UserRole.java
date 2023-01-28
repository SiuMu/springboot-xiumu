package com.xiumu.pojo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xiumu.common.core.entity.BaseEntity;
import lombok.Data;

/**
 * 用户角色关联 对象 sys_user_role
 *
 * @author XiuMu
 * @date 2022-07-23 01:07:42
 */
@Data
@TableName("sys_user_role")
public class UserRole extends BaseEntity {

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 角色ID
     */
    private Long roleId;

    public UserRole() {
    }

    public UserRole(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}

