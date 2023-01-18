package com.xiumu.common.core.exception.base;

/**
 * 用来定义无法用枚举定义的异常。
 * 例如，手动触发参数校验异常时候，异常字段不确定，无法定义成枚举
 *
 * @Author XiuMu
 * @Date 2023/1/18 15:20
 * @see com.xiumu.common.core.utils.ValidatorUtils
 **/
public class IBaseExceptionImpl implements IBaseException {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;

    public static IBaseExceptionImpl of(Integer code, String message) {
        return new IBaseExceptionImpl(code, message);
    }

    private IBaseExceptionImpl(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "自定义异常{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
