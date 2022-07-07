package com.xiumu.springbootxiumu.pojo.dto;

import com.xiumu.springbootxiumu.enums.AuthType;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 权限
 *
 * @author xiumu
 */
@Data
@Accessors(chain = true)
public class AuthorityDTO {

    /**
     * 父级ID
     */
    @NotNull(message = "父级不能为空")
    private Long parentId;

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
     * 权限类型，0菜单，1按钮，2接口
     */
    @NotNull(message = "权限类型不能为空")
    private AuthType authType;

}
