package com.xiumu.pojo.sys.model.dto;

import lombok.Data;

/**
 * 用户 对象 DTO
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:37
 */
@Data
public class UserDTO {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 性别，0男，1女，2未知
     */
    private Integer gender;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;

}

