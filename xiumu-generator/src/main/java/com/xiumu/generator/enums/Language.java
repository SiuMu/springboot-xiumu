package com.xiumu.generator.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * 开发语言枚举
 *
 * @Author XiuMu
 * @Date 2022/8/11
 **/
@Getter
public enum Language {

    RUST(10, "rust"),
    PYTHON(9, "python"),
    PHP(8, "php"),
    MARKDOWN(7, "markdown"),
    C_PLUS_PLUS(6, "c++"),
    XML(5, "xml"),
    JSON(4, "json"),
    CSS(3, "css"),
    HTML(2, "html"),
    JAVASCRIPT(1, "javascript"),
    JAVA(0, "java");

    @JsonValue
    @EnumValue
    private final Integer code;

    private final String desc;

    Language(Integer code, String desc) {
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
    public static Language codeOf(Integer code) {
        return Stream.of(Language.class.getEnumConstants())
                .filter(item -> item.code.equals(code))
                .findFirst()
                .orElse(null);
    }
}
