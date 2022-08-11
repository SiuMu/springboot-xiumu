package com.xiumu.generator.constants;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 生成配置
 *
 * @Author XiuMu
 * @Date 2022/7/16
 **/
@Data
@Accessors(chain = true)
public class GeneratorConfig {


    /**
     * 实体类名称(首字母大写)
     */
    private String className;

    /**
     * 生成包路径，
     * 与 XxxApplication 主类同级别的包路径
     * 不用写entity，pojo，service等路径
     */
    private String packageName;

    /**
     * 生成实体类包路径，
     * 与 XxxApplication 主类同级别的包路径
     * 不用写entity，pojo，service等路径
     */
    private String pojoPackageName;

    /**
     * 生成 dao 与 service 包路径，
     * 与 XxxApplication 主类同级别的包路径
     * 不用写entity，pojo，service等路径
     */
    private String servicePackageName;

    /**
     * 生成 controller 包路径，
     * 与 XxxApplication 主类同级别的包路径
     * 不用写entity，pojo，service等路径
     */
    private String controllerPackageName;

    /**
     * 生成模块名
     */
    private String moduleName;

    /**
     * 生成业务名, 用于生成 controller 中的请求路径 /xxx
     */
    private String businessName;

    /**
     * 生成功能名
     */
    private String functionName;

    /**
     * 生成作者
     */
    private String functionAuthor;

    /**
     * 生成路径，必须是某项目的 src 绝对路径
     * 格式： D:\xx\xx\xx\src
     * 例如: D:\ideaCode\lanmao\pojo\src
     */
    private String genPath;

    /**
     * 生成路径，POJO实体类模块的 src 绝对路径
     * 格式： D:\xx\xx\xx\src
     * 例如: D:\ideaCode\lanmao\pojo\src
     */
    private String pojoPath;

    /**
     * 生成路径，service 模块的 src 绝对路径
     * 格式： D:\xx\xx\xx\src
     * 例如: D:\ideaCode\lanmao\service\src
     */
    private String servicePath;

    /**
     * 生成路径，controller 模块的 src 绝对路径
     * 格式： D:\xx\xx\xx\src
     * 例如: D:\ideaCode\lanmao\web\src
     */
    private String controllerPath;
}
