package com.xiumu.springbootxiumu.pojo.dto;

import lombok.Data;

/**
 * 用户登录传参
 */
@Data
public class UserLoginDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
