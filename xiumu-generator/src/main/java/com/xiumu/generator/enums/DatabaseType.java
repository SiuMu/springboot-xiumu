package com.xiumu.generator.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiumu.generator.constants.Constants;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * 数据库类型枚举
 *
 * @Author XiuMu
 * @Date 2022/8/11
 **/
@Getter
public enum DatabaseType {

    ORACLE(2, "oracle", Constants.ORACLE_DRIVER_CLASS, Constants.ORACLE_URL_PREFIX, Constants.ORACLE_URL_SUFFIX),
    H2(1, "h2", Constants.H2_DRIVER_CLASS, Constants.H2_URL_PREFIX, Constants.H2_URL_SUFFIX),
    MYSQL(0, "MySql", Constants.MYSQL_DRIVER_CLASS, Constants.MYSQL_URL_PREFIX, Constants.MYSQL_URL_SUFFIX);

    @JsonValue
    @EnumValue
    private final Integer code;

    private final String desc;

    private final String driverClassName;

    private final String urlPrefix;

    private final String urlSuffix;

    DatabaseType(Integer code, String desc, String driverClassName, String urlPrefix, String urlSuffix) {
        this.code = code;
        this.desc = desc;
        this.driverClassName = driverClassName;
        this.urlPrefix = driverClassName;
        this.urlSuffix = driverClassName;
    }

    /**
     * Jackson反序列化
     *
     * @param code code
     * @return
     */
    @JsonCreator
    public static DatabaseType codeOf(Integer code) {
        return Stream.of(DatabaseType.class.getEnumConstants())
                .filter(item -> item.code.equals(code))
                .findFirst()
                .orElse(null);
    }
}
