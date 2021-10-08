package com.xiumu.springbootxiumu.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xiumu.springbootxiumu.pojo.base.BaseEntity;
import com.xiumu.springbootxiumu.utils.enums.Gender;
import lombok.Data;

@Data
@TableName("sys_user")
public class User extends BaseEntity {

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
