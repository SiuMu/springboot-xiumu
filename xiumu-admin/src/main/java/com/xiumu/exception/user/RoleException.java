package com.xiumu.exception.user;

import com.xiumu.common.core.exception.base.IBaseException;

/**
 * 角色相关异常
 * 1100-1199
 *
 * @Author XiuMu
 * @Date 2022/7/16
 */
public enum RoleException implements IBaseException {

    EMPTY_AUTH(1102, "权限编码不能为空"),
    CODE_EXIT(1101, "角色编码已经被使用"),
    NOT_EXIT(1100, "该角色不存在");

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
