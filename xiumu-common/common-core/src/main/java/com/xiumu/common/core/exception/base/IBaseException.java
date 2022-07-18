package com.xiumu.common.core.exception.base;

/**
 * 自定义的异常枚举基类
 * 其他异常枚举都需要实现该接口
 *
 * @Author XiuMu
 * @Date 2022/7/16
 */
public interface IBaseException {

    /**
     * 获取异常 code
     */
    Integer getCode();

    /**
     * 获取异常信息
     */
    String getMessage();
}
