package com.xiumu.springbootxiumu.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.exception.SaTokenException;
import com.xiumu.springbootxiumu.pojo.vo.ResultJSON;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public ResultJSON handlerBaseException(BaseException e) {
        CommonException content = e.getExceptionContent();
        return new ResultJSON(content.getCode(), content.getMsg());
    }

    /**
     * SaToken验证异常
     * @param e
     * @return
     */
    @ExceptionHandler(SaTokenException.class)
    public ResultJSON handlerSaTokenException(SaTokenException e){
        CommonException exception = CommonException.SERVE_FAIL;

        if (e instanceof NotLoginException){
            // 未登录
            exception = CommonException.NOT_LOGIN;
        }else if (e instanceof NotRoleException){
            // 没有权限
            exception = CommonException.AUTHORITY_FAIL;
        }else if (e instanceof NotPermissionException){
            // 没有权限
            exception = CommonException.AUTHORITY_FAIL;
        }

        return new ResultJSON(exception.getCode(),exception.getMsg());
    }

    /**
     * 未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultJSON handlerException(Exception e){
        System.out.println("不可预知的错误："+e.getMessage());
        return new ResultJSON(CommonException.SERVE_FAIL.getCode(),CommonException.SERVE_FAIL.getMsg());
    }
}
