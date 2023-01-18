package com.xiumu.enums;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * 权限类型枚举
 *
 * @Author XiuMu
 * @Date 2022/7/16
 */
@Getter
public enum AuthType {

    MENU(0, "菜单"),
    BUTTON(1, "按钮"),
    API(2, "API接口")
    ;

    AuthType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @JsonValue
    @EnumValue
    private final Integer code;

    private final String desc;

    /**
     * 根据 code 反序列化
     * 如果没有就返回 null
     *
     * @param code code
     * @return
     */
    @JsonCreator
    public static AuthType codeOf(Integer code) {
        return Stream.of(AuthType.class.getEnumConstants())
                .filter(item -> item.code.equals(code))
                .findFirst()
                .orElse(null);
    }


}
