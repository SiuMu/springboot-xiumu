package com.xiumu.common.core.utils;

import com.xiumu.common.core.exception.base.IBaseException;
import com.xiumu.common.core.exception.base.XiuMuException;

/**
 * 断言工具类，用于判断并抛出异常
 * 例如，isNull 抛出异常
 *
 * @Author XiuMu
 * @Date 2022/7/16
 */
public class AssertUtil {

    /**
     * 断言不能为空
     *
     * @param object    对象
     * @param exception 异常枚举
     */
    public static void isNotNull(Object object, IBaseException exception) {
        if (object == null) {
            throw new XiuMuException(exception);
        }
    }

    /**
     * 断言必须为空
     *
     * @param object    对象
     * @param exception 异常枚举
     */
    public static void isNull(Object object, IBaseException exception) {
        if (object != null) {
            throw new XiuMuException(exception);
        }
    }

    /**
     * 断言必须为True
     *
     * @param expression 布尔值
     * @param exception  异常
     */
    public static void isTrue(boolean expression, IBaseException exception) {
        if (!expression) {
            throw new XiuMuException(exception);
        }
    }

    /**
     * 断言必须为 False
     *
     * @param expression 布尔值
     * @param exception  异常
     */
    public static void isFalse(boolean expression, IBaseException exception) {
        if (expression) {
            throw new XiuMuException(exception);
        }
    }

}
