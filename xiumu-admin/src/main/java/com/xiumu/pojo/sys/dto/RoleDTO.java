package com.xiumu.pojo.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
    @NotBlank(message = "角色名称不能为空！")
    private String roleName;
    /**
     * 角色编码
     */
    @NotBlank(message = "角色名称不能为空")
    @Pattern(regexp = "^[a-z_]+", message = "权限编码只允许输入小写英文字母 a-z 和下划线 _")
    private String roleCode;
    /**
     * 角色描述
     */
    private String roleDesc;

}

