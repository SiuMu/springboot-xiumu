package com.xiumu.springbootxiumu.utils.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 性别枚举值，男，女，未知。。。
 */
@Getter
public enum Gender {

    UNKNOWN(2,"未知"),
    FEMALE(1,"女"),
    MAIL(0,"男");

    @EnumValue
    @JsonValue
    private final int code;

    private final String desc;

    Gender(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
