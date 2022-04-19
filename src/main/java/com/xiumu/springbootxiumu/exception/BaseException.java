package com.xiumu.springbootxiumu.exception;

/**
 * 异常枚举
 * 1000 - 2000
 */
public enum BaseException {


    REPEAT_USERNAME(1004, "用户名已经被注册！！"),
    AUTHORITY_FAIL(1003, "没有相关权限！！"),
    LOGIN_FAIL(1002, "用户名或者密码有误！"),
    NOT_LOGIN(1001, "登录失效！请重新登录"),
    SERVE_FAIL(500, "服务器繁忙!");


    private int code;

    private String msg;

    BaseException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
