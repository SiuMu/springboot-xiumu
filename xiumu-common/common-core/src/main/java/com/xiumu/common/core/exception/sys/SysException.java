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

    SERVE_FAIL(500, "服务器繁忙! 请稍后再试！");

    private final Integer code;

    private final String message;

    SysException(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
