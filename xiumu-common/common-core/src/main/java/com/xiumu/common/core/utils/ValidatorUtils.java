package com.xiumu.common.core.utils;

import com.xiumu.common.core.exception.base.IBaseExceptionImpl;
import com.xiumu.common.core.exception.base.XiuMuException;
import com.xiumu.common.core.exception.sys.SysException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 手动校验工具类，手动触发参数校验
 *
 * @Author XiuMu
 * @Date 2023/1/18 14:54
 **/
public class ValidatorUtils {

    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 手动校验对象传参
     * 只返回第一个错误
     */
    public static <T> void validate(T t) {
        Set<ConstraintViolation<T>> errors = VALIDATOR.validate(t);
        if (errors.size() > 0) {
            for (ConstraintViolation<T> error : errors) {
                throw new XiuMuException(IBaseExceptionImpl.of(SysException.PARAM_ERROR.getCode(), error.getMessage()));
            }
        }
    }
}
