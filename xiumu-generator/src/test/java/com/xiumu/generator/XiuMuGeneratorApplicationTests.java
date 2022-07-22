package com.xiumu.generator;

import com.xiumu.generator.config.GeneratorConfig;
import com.xiumu.generator.entity.GeneratorBO;
import com.xiumu.generator.service.GeneratorService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@MapperScan({"com.xiumu.generator.mapper"})
@SpringBootTest
public class XiuMuGeneratorApplicationTests {

    @Autowired
    private GeneratorService generatorService;

    /**
     * 生成某个表
     *
     * @throws Exception
     */
    @Test
    public void testCreateOneTable() throws Exception {
        // 数据库名
        String databaseName = "xiumu";
        // 表名
        String tableName = "sys_user_role";
        // 配置信息
        GeneratorConfig config = new GeneratorConfig()
                .setFunctionAuthor("XiuMu")                     // 设置作者名字
                .setModuleName("sys")                           // 设置模块名
                .setClassName("UserRole")                    // 设置类名
                .setFunctionName("用户角色关联")                         // 设置该对象的功能作用，表的中文名即可
                .setBusinessName("user")                 // 设置生成业务名，如 controller 中的请求路径 /shop
                .setPojoPackageName("com.xiumu.pojo")     // 设置实体类包路径
                .setServicePackageName("com.xiumu.service")    // 设置 dao 与 service 包路径
                .setControllerPackageName("com.xiumu.controller")     // 设置 controller 包路径
                .setPojoPath("D:\\openProject\\xiumu\\xiumu-admin\\src")      // 实体类项目的 src 路径
                .setServicePath("D:\\openProject\\xiumu\\xiumu-admin\\src") // dao 与 service 的 src 路径
                .setControllerPath("D:\\openProject\\xiumu\\xiumu-admin\\src"); // controller 的 src 路径
        // 生成代码
        generatorService.createCode(new GeneratorBO(databaseName, tableName, config));
    }

    /**
     * 生成某些表
     *
     * @throws Exception
     */
    @Test
    public void testCreateTableList() throws Exception {
        // 数据库名
        String databaseName = "xiumu";
        // 表名
        String tableName = "sys_role_auth";
        // 配置信息
        GeneratorConfig config = new GeneratorConfig()
                .setFunctionAuthor("XiuMu")                     // 设置作者名字
                .setModuleName("sys")                           // 设置模块名
                .setClassName("RoleAuth")                    // 设置类名
                .setFunctionName("角色权限关联")                         // 设置该对象的功能作用，表的中文名即可
                .setBusinessName("role")                 // 设置生成业务名，如 controller 中的请求路径 /shop
                .setPojoPackageName("com.xiumu.pojo")     // 设置实体类包路径
                .setServicePackageName("com.xiumu")    // 设置 dao 与 service 包路径
                .setControllerPackageName("com.xiumu.controller")     // 设置 controller 包路径
                .setPojoPath("D:\\openProject\\xiumu\\xiumu-admin\\src")      // 实体类项目的 src 路径
                .setServicePath("D:\\openProject\\xiumu\\xiumu-admin\\src") // dao 与 service 的 src 路径
                .setControllerPath("D:\\openProject\\xiumu\\xiumu-admin\\src"); // controller 的 src 路径
        // 生成代码
        List<GeneratorBO> generatorBOList = new ArrayList<>();

        generatorBOList.add(new GeneratorBO(databaseName, tableName, config));
        generatorBOList.add(new GeneratorBO(databaseName, "sys_user",
                config.setClassName("User").setFunctionName("用户").setBusinessName("user")));
        generatorBOList.add(new GeneratorBO(databaseName, "sys_user_role",
                config.setClassName("UserRole").setFunctionName("用户角色关联").setBusinessName("user")));

        generatorService.createCode(generatorBOList);
    }
}
