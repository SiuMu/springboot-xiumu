package com.xiumu.pojo.sys.model.query;

import lombok.Data;

/**
 * 查询 用户角色关联 对象
 *
 * @author XiuMu
 * @date 2022-07-23 01:07:42
 */
@Data
public class UserRoleQuery {

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 更新人
     */
    private String updateBy;

}

