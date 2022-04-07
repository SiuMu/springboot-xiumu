package com.xiumu.springbootxiumu.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.exception.SaTokenException;
import com.xiumu.springbootxiumu.pojo.vo.ResultJSON;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

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
    @ExceptionHandler(BizException.class)
    public ResultJSON handlerBaseException(BizException e) {
        BaseException content = e.getExceptionContent();
        return new ResultJSON(content.getCode(), content.getMsg());
    }

    /**
     * SaToken验证异常
     * @param e
     * @return
     */
    @ExceptionHandler(SaTokenException.class)
    public ResultJSON handlerSaTokenException(SaTokenException e){
        BaseException exception = BaseException.SERVE_FAIL;

        if (e instanceof NotLoginException){
            // 未登录
            exception = BaseException.NOT_LOGIN;
        }else if (e instanceof NotRoleException){
            // 没有权限
            exception = BaseException.AUTHORITY_FAIL;
        }else if (e instanceof NotPermissionException){
            // 没有权限
            exception = BaseException.AUTHORITY_FAIL;
        }

        return new ResultJSON(exception.getCode(),exception.getMsg());
    }

    /**
     * 参数校验异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultJSON HandlerParamsValidException(MethodArgumentNotValidException e){
        // 返回参数校验中定义的错误信息
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        return ResultJSON.failure(errors.get(0).getDefaultMessage());
    }

    /**
     * 未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultJSON handlerException(Exception e){
        System.out.println("不可预知的错误："+e.getMessage());
        return new ResultJSON(BaseException.SERVE_FAIL.getCode(), BaseException.SERVE_FAIL.getMsg());
    }
}
