package com.xiumu.springbootxiumu.utils.lang;

import com.xiumu.springbootxiumu.exception.BaseException;
import com.xiumu.springbootxiumu.exception.BizException;

/**
 * 断言工具类，用于判断并抛出异常
 * 例如，isNull 抛出异常
 */
public class AssertUtil {

    /**
     * 断言不能为空
     *
     * @param object    对象
     * @param exception 异常枚举
     */
    public static void notNull(Object object, BaseException exception) {
        if (object == null) {
            throw new BizException(exception);
        }
    }

    /**
     * 断言必须为空
     *
     * @param object    对象
     * @param exception 异常枚举
     */
    public static void isNull(Object object, BaseException exception) {
        if (object != null) {
            throw new BizException(exception);
        }
    }

    /**
     * 断言必须为True
     *
     * @param expression 布尔值
     * @param exception  异常
     */
    public static void isTrue(boolean expression, BaseException exception) {
        if (!expression) {
            throw new BizException(exception);
        }
    }

}
