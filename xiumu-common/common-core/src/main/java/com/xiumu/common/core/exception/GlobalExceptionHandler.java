package com.xiumu.common.core.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.exception.SaTokenException;
import com.xiumu.common.core.exception.base.IBaseException;
import com.xiumu.common.core.exception.base.XiuMuException;
import com.xiumu.common.core.exception.sys.SysException;
import com.xiumu.common.core.exception.user.UserException;
import com.xiumu.common.core.result.ResultJSON;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 全局异常处理
 *
 * @Author XiuMu
 * @Date 2022/7/16
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 自定义异常
     *
     * @param e 异常
     * @return
     */
    @ExceptionHandler(XiuMuException.class)
    public ResultJSON handlerBaseException(XiuMuException e) {
        IBaseException content = e.getExceptionContent();
        return ResultJSON.failure(content.getCode(), content.getMessage());
    }

    /**
     * SaToken验证异常
     *
     * @param e 异常
     * @return
     */
    @ExceptionHandler(SaTokenException.class)
    public ResultJSON handlerSaTokenException(SaTokenException e) {
        IBaseException exception = SysException.SERVE_FAIL;

        if (e instanceof NotLoginException) {
            // 未登录
            exception = UserException.NOT_LOGIN;
        } else if (e instanceof NotRoleException) {
            // 没有权限
            exception = UserException.AUTHORITY_FAIL;
        } else if (e instanceof NotPermissionException) {
            // 没有权限
            exception = UserException.AUTHORITY_FAIL;
        }

        return ResultJSON.failure(exception.getCode(), exception.getMessage());
    }

    /**
     * 参数校验异常处理
     *
     * @param e 异常
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultJSON HandlerParamsValidException(MethodArgumentNotValidException e) {
        // 返回参数校验中定义的错误信息
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        return ResultJSON.failure(errors.get(0).getDefaultMessage());
    }

    /**
     * 未知异常
     *
     * @param e 异常
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultJSON handlerException(Exception e) {
        System.out.println("不可预知的错误：" + e.getMessage());
        return ResultJSON.failure(SysException.SERVE_FAIL.getCode(), SysException.SERVE_FAIL.getMessage());
    }
}
