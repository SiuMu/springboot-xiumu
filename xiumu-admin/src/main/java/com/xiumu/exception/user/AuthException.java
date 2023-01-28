package com.xiumu.exception.user;

import com.xiumu.common.core.exception.base.IBaseException;
import lombok.Getter;

/**
 * 权限相关异常枚举
 * 1200 - 1299
 *
 * @Author XiuMu
 * @Date 2022/7/16
 */
@Getter
public enum AuthException implements IBaseException {

    NO_MENU_INFO(1203, "菜单信息不能为空！"),
    NOT_IS_MENU(1202, "只有菜单才能新建子级权限！"),
    REPEAT_CODE(1201, "权限编码已经被使用！"),
    NOT_EXIT(1200, "该权限不存在！");


    private final Integer code;

    private final String message;

    AuthException(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
