package com.xiumu.common.core.exception.user;

import com.xiumu.common.core.exception.base.IBaseException;

/**
 * 1200-1299
 *
 * @Author XiuMu
 * @Date 2022/7/16
 */
public enum RoleException implements IBaseException {

    CODE_EXIT(1201, "角色编码已经被使用"),
    NOT_EXIT(1200, "该角色不存在");

    private final Integer code;

    private final String message;

    RoleException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
