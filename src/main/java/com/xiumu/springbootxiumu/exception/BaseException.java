package com.xiumu.springbootxiumu.exception;

import lombok.Data;

@Data
public class BaseException extends RuntimeException {

    /**
     * 异常的枚举
     */
    private CommonException exceptionContent;

    public BaseException(CommonException exceptionContent) {
        this.exceptionContent = exceptionContent;
    }
}
