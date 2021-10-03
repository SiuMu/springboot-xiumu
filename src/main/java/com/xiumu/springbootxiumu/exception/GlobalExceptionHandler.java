package com.xiumu.springbootxiumu.exception;

import com.xiumu.springbootxiumu.pojo.vo.ResultJSON;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BaseException.class)
    public ResultJSON handlerBaseException(BaseException e) {
        CommonException content = e.getExceptionContent();
        return new ResultJSON(content.getCode(), content.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public ResultJSON handlerException(Exception e){
        System.out.println("不可预知的错误："+e.getMessage());
        return new ResultJSON(CommonException.SERVE_FAIL.getCode(),CommonException.SERVE_FAIL.getMsg());
    }
}
