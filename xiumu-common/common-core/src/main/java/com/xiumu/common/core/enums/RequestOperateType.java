package com.xiumu.common.core.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * 请求的操作类型，查询、新增、修改、删除、登录，退出
 *
 * @Author XiuMu
 * @Date 2023/1/7 22:56
 **/
@Getter
public enum RequestOperateType {
    /**
     * 查询
     */
    QUERY(0, "查询"),
    /**
     * 新增
     */
    CREATE(1, "新增"),
    /**
     * 修改
     */
    MODIFY(2, "修改"),
    /**
     * 删除
     */
    DELETE(3, "删除"),
    /**
     * 登录
     */
    LOGIN(4, "登录"),
    /**
     * 退出
     */
    LOGOUT(5, "退出")
    ;

    @JsonValue
    @EnumValue
    private final Integer code;

    private final String desc;

    RequestOperateType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Jackson反序列化，使用Stream流查找
     *
     * @param code code
     * @return
     */
    @JsonCreator
    public static RequestOperateType codeOf(Integer code) {
        return Stream.of(values())
                .filter(item -> item.getCode().equals(code))
                .findAny().orElse(null);
    }
}
