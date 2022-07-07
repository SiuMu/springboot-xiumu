package com.xiumu.springbootxiumu.exception.user;

import com.xiumu.springbootxiumu.exception.base.IBaseException;
import lombok.Getter;

/**
 * 异常枚举
 * 2000 - 2999
 */
@Getter
public enum AuthException implements IBaseException {


    NOT_MENU(2002, "只有菜单才能新建子级权限！"),
    REPEAT_CODE(2001, "权限编码已经被使用！"),
    NOT_EXIT(2000, "该权限不存在！");


    private final Integer code;

    private final String message;

    AuthException(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
