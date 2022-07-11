package com.xiumu.springbootxiumu.pojo.dto;

import com.xiumu.springbootxiumu.enums.Gender;
import com.xiumu.springbootxiumu.enums.YesNo;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 用户
 */
@Data
public class UserDTO {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;
    /**
     * 是否设置密码
     * 否就设置为默认密码 123456
     */
    private YesNo setPassword;

    /**
     * 密码
     */
    private String password;

    /**
     * 确认密码，设置密码时必须两次输入一致
     */
    private String confirmPassword;

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

    /**
     * 角色
     */
    @Size(min = 1, message = "用户角色不能为空")
    private List<Long> roleList;

}
