package com.xiumu.pojo.sys.dto;

import lombok.Data;

/**
 * 用户角色关联 对象 DTO
 *
 * @author XiuMu
 * @date 2022-07-23 01:07:42
 */
@Data
public class UserRoleDTO {

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

