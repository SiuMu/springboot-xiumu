package com.xiumu.springbootxiumu.exception.base;

import lombok.Data;

@Data
public class XiuMuException extends RuntimeException {

    /**
     * 异常的枚举
     */
    private IBaseException exceptionContent;

    public XiuMuException(IBaseException exceptionContent) {
        this.exceptionContent = exceptionContent;
    }
}
