package com.xiumu.exception.user;

import com.xiumu.common.core.exception.base.IBaseException;
import lombok.Getter;

/**
 * 异常枚举
 * 1300 - 1399
 *
 * @Author XiuMu
 * @Date 2022/7/16
 */
@Getter
public enum AuthException implements IBaseException {


    NOT_MENU(1302, "只有菜单才能新建子级权限！"),
    REPEAT_CODE(1301, "权限编码已经被使用！"),
    NOT_EXIT(1300, "该权限不存在！");


    private final Integer code;

    private final String message;

    AuthException(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
