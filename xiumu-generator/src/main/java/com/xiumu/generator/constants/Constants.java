package com.xiumu.generator.constants;

import com.xiumu.generator.VelocityInitializer;

import java.util.Arrays;
import java.util.List;

/**
 * 常量
 *
 * @Author XiuMu
 * @Date 2022/7/16
 **/
public class Constants {

    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * 生成实体类的时候需要忽略的字段
     */
    public static final List<String> IGNORE_COLUMN = Arrays.asList("id", "create_time", "create_by", "update_time", "update_by", "delete_flag");

    /**
     * 代码生成器模板名称
     * 在 {@link VelocityInitializer} 中初始化
     */
    public static String[] VM_LIST = {};


    /**
     * 代码生成器模板信息表
     */
    public static final String CODE_TEMPLATE_TABLE = "xiumu_code_template";

    /**
     * 代码生成器模板信息表
     */
    public static final String DATABASE_TABLE = "xiumu_database";

    /**
     * mysql 数据源连接 URL 前缀
     */
    public static final String MYSQL_URL_PREFIX = "jdbc:mysql://";

    /**
     * mysql 数据源连接 URL 后缀
     */
    public static final String MYSQL_URL_SUFFIX = "?useUnicode=true&characterEncoding=utf8&useSSL=false";


    /**
     * mysql 数据源连接 driver-class-name
     */
    public static final String MYSQL_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    /**
     * H2 数据源连接 driver-class-name
     */
    public static final String H2_DRIVER_CLASS = "org.h2.Driver";

    /**
     * H2 数据源连接 URL 前缀
     */
    public static final String H2_URL_PREFIX = "jdbc:h2:";

    /**
     * H2 数据源连接 URL 后缀
     */
    public static final String H2_URL_SUFFIX = "jdbc:h2:";

    /**
     * oracle 数据源连接 driver-class-name
     */
    public static final String ORACLE_DRIVER_CLASS = "oracle.jdbc.OracleDriver";


    /**
     * H2 数据源连接 URL 前缀
     */
    public static final String ORACLE_URL_PREFIX = "jdbc:oracle:thin:@";

    /**
     * H2 数据源连接 URL 后缀
     */
    public static final String ORACLE_URL_SUFFIX = "";

}
