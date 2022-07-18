package com.xiumu.common.core.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * 枚举值，是 或者 否
 *
 * @Author XiuMu
 * @Date 2022/7/16
 **/
@Getter
public enum YesNo {

    YES(1, "是"),
    NO(0, "否");

    @JsonValue
    @EnumValue
    private final Integer code;

    private final String desc;

    YesNo(Integer code, String desc) {
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
    public static YesNo codeOf(Integer code) {
        return Stream.of(values())
                .filter(item -> item.getCode().equals(code))
                .findAny().orElse(null);
    }

}
