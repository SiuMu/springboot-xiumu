package com.xiumu.springbootxiumu.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * 枚举值，是 或者 否
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum YesNo {

    YES("1","是"),
    NO("0","否");

    @EnumValue
    private final String code;

    private final String desc;

    YesNo(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Jackson反序列化，使用Stream流查找
     * @param code code
     * @return
     */
    @JsonCreator
    public static YesNo codeOf(String code){
        return Stream.of(values())
                .filter(item -> item.getCode().equals(code))
                .findAny().orElse(null);
    }

}
