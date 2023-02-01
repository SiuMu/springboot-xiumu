package com.xiumu.common.core.exception.sys;

import com.xiumu.common.core.exception.base.IBaseException;
import lombok.Getter;

/**
 * 异常枚举
 * 0 - 999
 *
 * @Author XiuMu
 * @Date 2022/7/16
 */
@Getter
public enum SysException implements IBaseException {

    PASSWD_ERROR(100, "用户名或者密码有误！"),
    PARAM_ERROR(101, "参数校验异常"),
    NOT_LOGIN(300, "未登录！请先登录"),
    NOT_AUTHORITY(400, "没有相关权限！！"),
    INVALID_HTTP_METHOD(450, "错误的 http 请求方式"),
    SERVE_FAIL(500, "服务器繁忙! 请稍后再试！"),
    REPEAT_ITEM(600, "该项重复，请勿重复添加")
    ;

    private final Integer code;

    private final String message;

    SysException(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
