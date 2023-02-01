package com.xiumu.common.core.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.exception.SaTokenException;
import com.xiumu.common.core.exception.base.IBaseException;
import com.xiumu.common.core.exception.sys.SysException;
import com.xiumu.common.core.exception.base.XiuMuException;
import com.xiumu.common.core.result.ResultJSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
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
 * @author XiuMu
 * @Date 2022-11-9 21:04
 **/
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
     * 参数校验异常处理, 表单格式提交
     *
     * @param e 异常
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResultJSON<Boolean> HandlerParamsValidException(BindException e) {
        log.error("参数校验异常, 表单格式提交", e);
        // 返回参数校验中定义的错误信息
        String error = e.getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(","));
        return ResultJSON.failure(SysException.PARAM_ERROR.getCode(), error);
    }

    /**
     * 参数校验异常处理, json 格式提交
     *
     * @param e 异常
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultJSON<Boolean> paramsValidException(MethodArgumentNotValidException e) {
        log.error("参数校验异常, json 格式提交", e);
        // 返回参数校验中定义的错误信息
        String error = e.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(","));
        return ResultJSON.failure(SysException.PARAM_ERROR.getCode(), error);
    }

    /**
     * 参数绑定异常，例如 String 类型无法解析到 Long 类型字段上; Date 类型解析失败等
     * Http 请求缺少 body, 或者 body 内容格式不正确，无法进行 JSON 反序列化
     *
     * @param e 异常
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResultJSON<Boolean> paramsValidException(HttpMessageNotReadableException e) {
        log.error("请求参数无法绑定", e);
        // 返回参数绑定异常的错误信息
        return ResultJSON.failure(SysException.PARAM_ERROR.getCode(), e.getMessage());
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
        return ResultJSON.failure(SysException.PARAM_ERROR.getCode(), e.getMessage());
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
        String error = "缺少自定义请求头：[" + e.getHeaderName() + "]";
        return ResultJSON.failure(SysException.PARAM_ERROR.getCode(), error);
    }


    /**
     * http 请求方式错误, 例如用 GET 请求调用 POST 接口
     *
     * @param e 异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultJSON<Boolean> paramsValidException(HttpRequestMethodNotSupportedException e) {
        log.error("错误的 Http Method", e);
        return ResultJSON.failure(SysException.INVALID_HTTP_METHOD);
    }

    /**
     * 数据库唯一索引重复添加
     *
     * @param e 异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(DuplicateKeyException.class)
    public ResultJSON<Boolean> paramsValidException(DuplicateKeyException e) {
        log.error("数据库唯一索引重复添加", e);
        return ResultJSON.failure(SysException.REPEAT_ITEM);
    }

    /**
     * 未知异常
     *
     * @param e 异常
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultJSON<Boolean> handlerException(Exception e) {
        log.error("系统未知异常：", e);
        return ResultJSON.failure(SysException.SERVE_FAIL);
    }
}
