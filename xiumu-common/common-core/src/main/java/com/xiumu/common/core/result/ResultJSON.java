package com.xiumu.common.core.result;

import com.xiumu.common.core.enums.RequestOperateType;
import com.xiumu.common.core.exception.base.IBaseException;
import lombok.Data;

/**
 * 返回统一JSON信息
 * 返回的具体数据使用泛型
 *
 * @Author XiuMu
 * @Date 2022/7/16
 **/
@Data
public class ResultJSON<T> {

    /**
     * 请求的操作类型，查询、新增、修改、删除
     */
    private RequestOperateType operateType;

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
    private T result;



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

    public ResultJSON(Integer code, String msg, T result, RequestOperateType operateType) {
        this.code = code;
        this.msg = msg;
        this.result = result;
        this.operateType = operateType;
    }

    /**
     * 查询成功
     *
     * @param result 返回结果
     */
    public static <T> ResultJSON<T> querySuccess(T result) {
        return new ResultJSON<T>(200, "查询成功", result, RequestOperateType.QUERY);
    }

    /**
     * 创建成功
     *
     */
    public static <T> ResultJSON<T> createSuccess() {
        return new ResultJSON<>(200, "创建成功", null, RequestOperateType.CREATE);
    }

    /**
     * 创建成功
     *
     */
    public static <T> ResultJSON<T> createSuccess(T result) {
        return new ResultJSON<>(200, "创建成功", result, RequestOperateType.CREATE);
    }

    /**
     * 修改成功
     *
     */
    public static <T> ResultJSON<T> modifySuccess() {
        return new ResultJSON<>(200, "修改成功", null, RequestOperateType.MODIFY);
    }

    /**
     * 修改成功
     *
     */
    public static <T> ResultJSON<T> modifySuccess(T result) {
        return new ResultJSON<>(200, "修改成功", result, RequestOperateType.MODIFY);
    }

    /**
     * 删除成功
     *
     */
    public static <T> ResultJSON<T> deleteSuccess() {
        return new ResultJSON<>(200, "删除成功", null, RequestOperateType.DELETE);
    }

    /**
     * 删除成功
     *
     */
    public static <T> ResultJSON<T> deleteSuccess(T result) {
        return new ResultJSON<>(200, "删除成功", result, RequestOperateType.DELETE);
    }

    /**
     * 成功返回数据
     *
     * @param result 返回结果
     */
    public static <T> ResultJSON<T> success(T result, RequestOperateType operateType) {
        String msg = "请求成功";
        if (operateType == RequestOperateType.LOGIN){
            msg = "登录成功";
        }else if (operateType == RequestOperateType.LOGOUT){
            msg = "退出成功";
        }
        return new ResultJSON<>(200, msg, result, operateType);
    }

    /**
     * 请求失败
     */
    public static ResultJSON<Boolean> failure(Integer code, String msg) {
        return new ResultJSON<>(code, msg, false, RequestOperateType.QUERY);
    }

    /**
     * 请求失败
     */
    public static ResultJSON<Boolean> failure(IBaseException exception) {
        return new ResultJSON<>(exception.getCode(), exception.getMessage(), false, RequestOperateType.QUERY);
    }

}
