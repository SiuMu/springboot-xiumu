package com.xiumu.exception.user;

import com.xiumu.common.core.exception.base.IBaseException;
import lombok.Getter;

/**
 * 用户相关异常枚举
 * 1000 - 1099
 *
 * @Author XiuMu
 * @Date 2022/7/16
 */
@Getter
public enum UserException implements IBaseException {


    NOT_EXIT(1007, "用户不存在"),
    CONFIRM_PASSWORD_ERROR(1006, "两次密码输入不一致"),
    NOT_ENABLED(1005, "用户已经被禁用！！"),
    EXITED(1004, "用户名已经被注册！！");


    private final Integer code;

    private final String message;

    UserException(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
