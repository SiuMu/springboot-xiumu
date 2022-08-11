package com.xiumu.generator.exception;

import com.xiumu.common.core.exception.base.IBaseException;
import lombok.Getter;

/**
 * 代码生成器项目自定义异常
 * -999 ~ -100
 */
@Getter
public enum GenException implements IBaseException {

    DATABASE_EXIST(-999, "该数据源已经存在")
    ;

    private final Integer code;

    private final String message;

    GenException(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
