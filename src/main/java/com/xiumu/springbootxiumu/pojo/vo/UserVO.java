package com.xiumu.springbootxiumu.pojo.vo;

import com.xiumu.springbootxiumu.utils.enums.Gender;
import lombok.Data;

/**
 * 返回给前端用的用户信息
 */
@Data
public class UserVO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 性别，0男，1女，2未知
     */
    private Gender gender;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

}
