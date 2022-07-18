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

}
