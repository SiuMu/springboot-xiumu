package com.xiumu.pojo.sys.dto;

import lombok.Data;

/**
 * 角色权限关联 对象 DTO
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:06
 */
@Data
public class RoleAuthDTO {

    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 权限ID
     */
    private Long authId;

}

