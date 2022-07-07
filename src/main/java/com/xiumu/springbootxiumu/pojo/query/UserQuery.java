package com.xiumu.springbootxiumu.pojo.query;

import com.xiumu.springbootxiumu.enums.Gender;
import lombok.Data;

/**
 * 查询条件传参
 */
@Data
public class UserQuery {

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String userPhone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别，值为 0 时是男性，值为 1 时是女性，值为 2 时是未知
     */
    private Gender gender;
}
