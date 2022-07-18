package com.xiumu.generator;

import com.xiumu.generator.constants.Constants;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.util.Properties;

/**
 * VelocityEngine工厂
 */
public class VelocityInitializer {

    /**
     * 初始化vm方法
     */
    public static void initVelocity() {
        Properties p = new Properties();
        try {
            // 获取 xiumu-generator 模块的绝对路径
            String generatorPath = new File("").getCanonicalPath();
            // 获取 vm 文件夹所在绝对路径
            String vmPath = generatorPath + "\\src\\main\\resources\\vm";
            // 获取 vm 文件夹下面所有的文件名
            Constants.VM_LIST = new File(vmPath).list();
            // 加载classpath目录下的vm文件
            p.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, vmPath);
            // 定义字符集
            p.setProperty(Velocity.INPUT_ENCODING, Constants.UTF8);
            // 初始化Velocity引擎，指定配置Properties
            Velocity.init(p);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}
