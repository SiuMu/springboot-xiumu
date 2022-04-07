package com.xiumu.springbootxiumu.exception;

import lombok.Data;

@Data
public class BizException extends RuntimeException {

    /**
     * 异常的枚举
     */
    private BaseException exceptionContent;

    public BizException(BaseException exceptionContent) {
        this.exceptionContent = exceptionContent;
    }
}
