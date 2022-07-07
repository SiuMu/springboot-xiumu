package com.xiumu.springbootxiumu.exception.user;

import com.xiumu.springbootxiumu.exception.base.IBaseException;
import lombok.Getter;

/**
 * 异常枚举
 * 1000 - 1999
 */
@Getter
public enum UserException implements IBaseException {


    REPEAT_USERNAME(1004, "用户名已经被注册！！"),
    AUTHORITY_FAIL(1003, "没有相关权限！！"),
    LOGIN_FAIL(1002, "用户名或者密码有误！"),
    NOT_LOGIN(1001, "登录失效！请重新登录");


    private final Integer code;

    private final String message;

    UserException(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
