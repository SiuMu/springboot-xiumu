package com.xiumu.springbootxiumu.exception;


public enum CommonException {


    LOGIN_FAIL(102, "用户名或者密码有误！"),
    AUTHORITY_FAIL(403, "没有相关权限！！"),
    SERVE_FAIL(500, "服务器繁忙!");


    private int code;

    private String msg;

    CommonException(int code, String msg) {
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
