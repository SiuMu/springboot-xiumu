package com.xiumu.pojo.sys.dto;

import com.xiumu.enums.AuthType;
import lombok.Data;

import javax.validation.constraints.*;

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
    private Long parentId;
    /**
     * 权限编码
     * 权限验证的时候会进行正则匹配，避免出现 * 等一些特殊字符
     */
    @Pattern(regexp = "^[a-z:]+", message = "权限编码只允许输入英文字母和英文冒号")
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
    private AuthType authType;

    /**
     * 排序权重，值越小越靠前，最大值 30000
     */
    @Min(value = 1, message = "权重不得小于1")
    @Max(value = 30000, message = "权重最大不能超过 30000")
    private Integer weight;

    /**
     * 菜单信息
     * 如果新增的权限是菜单的话，需要传递该对象，并进行手动校验
     * @see com.xiumu.common.core.utils.ValidatorUtils#validate(Object)
     */
    private MenuDTO menu;
}

