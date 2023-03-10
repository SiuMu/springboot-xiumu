package com.xiumu.pojo.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录传参
 *
 * @Author XiuMu
 * @Date 2022/7/25
 **/
@Data
public class LoginDTO {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
}
