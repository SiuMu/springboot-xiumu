package com.xiumu.pojo.sys.query;

import lombok.Data;

/**
 * Query 对象，表示查询传参，需要查询并传递参数的时候，封装成该对象
 * <p>
 * 查询 用户 对象
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:37
 */
@Data
public class UserQuery {

    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickName;
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

