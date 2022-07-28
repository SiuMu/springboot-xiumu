package com.xiumu.pojo.sys.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 权限 对象 DTO
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:15
 */
@Data
public class AuthorityDTO {

    /**
     * 父级ID
     */
    @NotBlank(message = "父级权限不能为空")
    private String parentId;
    /**
     * 权限编码
     */
    @NotBlank(message = "权限编码不能为空")
    private String authCode;
    /**
     * 权限名称
     */
    @NotBlank(message = "权限名称不能为空")
    private String authName;
    /**
     * 权限描述
     */
    @NotBlank(message = "权限描述不能为空")
    private String authDesc;
    /**
     * 权限类型，0 菜单，1 按钮，2 接口
     */
    @NotNull(message = "权限类型不能为空")
    private Integer authType;

    /**
     * 排序权重，值越小越靠前，最大值 30000
     */
    @Min(value = 1, message = "权重不得小于1")
    @Max(value = 30000, message = "权重最大不能超过 30000")
    private Integer weight;
}

