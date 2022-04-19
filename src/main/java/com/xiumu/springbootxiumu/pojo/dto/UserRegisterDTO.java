package com.xiumu.springbootxiumu.pojo.dto;

import com.xiumu.springbootxiumu.enums.Gender;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户注册传参
 */
@Data
public class UserRegisterDTO {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "用户名不能为空")
    private String password;

    /**
     * 性别，0男，1女，2未知
     */
    private Gender gender;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

}
