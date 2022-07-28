package com.xiumu.common.core.result;

import lombok.Data;

/**
 * 返回统一JSON信息
 *
 * @Author XiuMu
 * @Date 2022/7/16
 **/

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
     *
     * @param result 返回结果
     */
    public static ResultJSON postSuccess(Object result) {
        return new ResultJSON(200, "创建成功", result);
    }

    /**
     * 成功返回数据
     *
     * @param result 返回结果
     */
    public static ResultJSON putSuccess(Object result) {
        return new ResultJSON(200, "修改成功", result);
    }

    /**
     * 成功返回数据
     *
     * @param result 返回结果
     */
    public static ResultJSON deleteSuccess(Object result) {
        return new ResultJSON(200, "删除成功", result);
    }

    /**
     * 成功返回数据
     *
     * @param result 返回结果
     */
    public static ResultJSON success(Object result) {
        return new ResultJSON(200, "删除成功", result);
    }


    /**
     * 成功返回，无数据
     */
    public static ResultJSON success() {
        return new ResultJSON(200, "操作成功", null);
    }

    /**
     * 请求失败
     */
    public static ResultJSON failure() {
        return new ResultJSON(500, "操作失败", null);
    }

    /**
     * 请求失败返回错误信息
     *
     * @param msg 错误信息
     * @return
     */
    public static ResultJSON failure(String msg) {
        return new ResultJSON(500, msg, null);
    }

    /**
     * 请求失败返回错误信息
     *
     * @param msg 错误信息
     * @return
     */
    public static ResultJSON failure(Integer code, String msg) {
        return new ResultJSON(code, msg, null);
    }

}
