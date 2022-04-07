package com.xiumu.springbootxiumu.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 用户登录传参
 */
@Data
public class UserLoginDTO {

    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String password;
}
