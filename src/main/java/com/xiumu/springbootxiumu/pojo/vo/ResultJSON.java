package com.xiumu.springbootxiumu.pojo.vo;

import lombok.Data;

/**
 * 返回统一JSON信息
 */
@Data
public class ResultJSON {
    /**
     * 返回的状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;


    /**
     * 返回的数据
     */
    private Object result;

    public ResultJSON() {
    }

    /**
     * 只返回状态码
     *
     * @param code 状态码
     */
    public ResultJSON(Integer code) {
        this.code = code;
    }

    /**
     * 不返回数据的构造方法
     *
     * @param code 状态码
     * @param msg  信息
     */
    public ResultJSON(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 返回数据的构造方法
     *
     * @param code   状态码
     * @param msg    信息
     * @param result 数据
     */
    public ResultJSON(Integer code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    /**
     * 返回状态码和数据
     *
     * @param code   状态码
     * @param result 数据
     */
    public ResultJSON(Integer code, Object result) {
        this.code = code;
        this.result = result;
    }

    /**
     * 成功返回数据
     * @param result 返回结果
     */
    public static ResultJSON success(Object result) {
        return new ResultJSON(200,"success",result);
    }

    /**
     * 成功返回，无数据
     */
    public static ResultJSON success() {
        return new ResultJSON(200,"success",null);
    }

    /**
     * 请求失败返回错误信息
     * @param msg   错误信息
     * @return
     */
    public static ResultJSON failure(String msg){
        return new ResultJSON(500, msg, null);
    }
}
