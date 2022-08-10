package com.xiumu.generator.exception;

import com.xiumu.common.core.exception.base.IBaseException;
import lombok.Getter;

/**
 * 代码生成器项目自定义异常
 * -999 ~ -100
 */
@Getter
public enum GenException implements IBaseException {
    NOT_EXIT_MY_DATABASE(-999, "xiumu 数据库未创建，请先创建数据库"),
    NOT_EXIT_MY_TABLE(-888, "xiumu 表结构未创建，请先创建表结构")
    ;

    private final Integer code;

    private final String message;

    GenException(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
