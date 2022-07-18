package com.xiumu.common.core.exception.base;

import lombok.Data;

/**
 * 自定义异常
 *
 * @Author XiuMu
 * @Date 2022/7/16
 **/
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
