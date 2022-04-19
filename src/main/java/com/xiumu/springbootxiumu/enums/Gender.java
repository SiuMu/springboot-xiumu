package com.xiumu.springbootxiumu.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 性别枚举值，男，女，未知。。。
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Gender {

    UNKNOWN("2","未知"),
    FEMALE("1","女"),
    MAIL("0","男");

    @EnumValue
    private final String code;

    private final String desc;

    Gender(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Jackson反序列化
     * @param code code
     * @return
     */
    @JsonCreator
    public static Gender codeOf(String code){
        for (Gender gender : Gender.values()) {
            if (gender.getCode().equals(code)){
                return gender;
            }
        }
        return null;
    }
}
