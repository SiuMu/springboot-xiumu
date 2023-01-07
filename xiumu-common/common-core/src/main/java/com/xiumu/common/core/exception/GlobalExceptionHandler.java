package com.xiumu.common.core.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.exception.SaTokenException;
import com.xiumu.common.core.exception.base.IBaseException;
import com.xiumu.common.core.exception.base.XiuMuException;
import com.xiumu.common.core.exception.sys.SysException;
import com.xiumu.common.core.result.ResultJSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 *
 * @Author XiuMu
 * @Date 2022/7/16
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 自定义异常
     *
     * @param e 异常
     * @return
     */
    @ExceptionHandler(XiuMuException.class)
    public ResultJSON<Boolean> handlerBaseException(XiuMuException e) {
        log.error("自定义异常", e);
        IBaseException content = e.getExceptionContent();
        return ResultJSON.failure(content.getCode(), content.getMessage());
    }

    /**
     * SaToken 验证异常
     *
     * @param e 异常
     * @return
     */
    @ExceptionHandler(SaTokenException.class)
    public ResultJSON<Boolean> handlerSaTokenException(SaTokenException e) {
        log.error("SaToken 验证异常", e);
        IBaseException exception = SysException.SERVE_FAIL;
        if (e instanceof NotLoginException) {
            // 未登录
            exception = SysException.NOT_LOGIN;
        } else if (e instanceof NotRoleException) {
            // 没有权限
            exception = SysException.NOT_AUTHORITY;
        } else if (e instanceof NotPermissionException) {
            // 没有权限
            exception = SysException.NOT_AUTHORITY;
        }

        return ResultJSON.failure(exception.getCode(), exception.getMessage());
    }

    /**
     * 参数校验异常处理
     *
     * @param e 异常
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResultJSON<Boolean> HandlerParamsValidException(BindException e) {
        log.error("参数校验异常处理", e);
        // 返回参数校验中定义的错误信息
        String error = e.getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(","));
        return ResultJSON.failure(SysException.SERVE_FAIL.getCode(), error);
    }

    /**
     * 参数校验异常处理, json 格式提交
     *
     * @param e 异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultJSON<Boolean> paramsValidException(MethodArgumentNotValidException e) {
        log.error("参数校验异常处理", e);
        // 返回参数校验中定义的错误信息
        String error = e.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(","));
        return ResultJSON.failure(SysException.SERVE_FAIL.getCode(), error);
    }

    /**
     * 参数校验异常处理, javax.validation 校验异常，例如文件上传，@NotNull MultipartFile
     *
     * @param e 异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultJSON<Boolean> paramsValidException(ConstraintViolationException e) {
        log.error("参数校验异常处理", e);
        return ResultJSON.failure(SysException.SERVE_FAIL.getCode(), e.getMessage());
    }

    /**
     * 参数校验异常处理, 缺少自定义请求头
     *
     * @param e 异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResultJSON<Boolean> paramsValidException(MissingRequestHeaderException e) {
        log.error("参数校验异常处理", e);
        // 返回参数校验中定义的错误信息
        String error = "缺少自定义请求头：[" + e.getHeaderName() + "]";
        return ResultJSON.failure(SysException.SERVE_FAIL.getCode(), error);
    }

    /**
     * 未知异常
     *
     * @param e 异常
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultJSON<Boolean> handlerException(Exception e) {
        log.error("未知异常, 系统错误", e);
        return ResultJSON.failure(SysException.SERVE_FAIL.getCode(), SysException.SERVE_FAIL.getMessage());
    }
}
