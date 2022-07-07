package com.xiumu.springbootxiumu.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 角色
 */
@Data
public class RoleDTO {

    /**
     * 角色编码
     */
    @NotBlank(message = "角色编码不能为空")
    private String roleCode;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    /**
     * 角色描述
     */
    @NotBlank(message = "角色描述不能为空")
    private String roleDesc;

    /**
     * 权限列表
     */
    @Size(min = 1, message = "权限不能为空")
    private List<Long> authList;
}
