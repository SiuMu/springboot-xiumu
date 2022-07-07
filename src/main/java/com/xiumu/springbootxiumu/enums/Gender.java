package com.xiumu.springbootxiumu.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 性别枚举值，男，女，未知。。。
 */
@Getter
public enum Gender {

    UNKNOWN(2, "未知"),
    FEMALE(1, "女"),
    MAIL(0, "男");

    @JsonValue
    @EnumValue
    private final Integer code;

    private final String desc;

    Gender(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Jackson反序列化
     *
     * @param code code
     * @return
     */
    @JsonCreator
    public static Gender codeOf(Integer code) {
        for (Gender gender : Gender.values()) {
            if (gender.getCode().equals(code)) {
                return gender;
            }
        }
        return null;
    }
}
