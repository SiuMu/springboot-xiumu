package com.xiumu.springbootxiumu.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 枚举值，是 或者 否
 */
@Getter
public enum YesNo {

    YES(1,"是"),
    NO(0,"否");

    @EnumValue
    private final int code;

    private final String desc;

    YesNo(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
