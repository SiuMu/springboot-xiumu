package com.xiumu.pojo.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 角色 对象 DTO
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:52
 */
@Data
public class RoleDTO {

    /**
     * 角色名称
     */
    @NotEmpty(message = "角色名称不能为空！")
    private String roleName;
    /**
     * 角色编码
     */
    @NotEmpty(message = "角色编码不能为空！")
    private String roleCode;
    /**
     * 角色描述
     */
    private String roleDesc;

}

