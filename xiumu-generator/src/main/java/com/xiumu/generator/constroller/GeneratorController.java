package com.xiumu.generator.constroller;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.xiumu.common.core.exception.base.XiuMuException;
import com.xiumu.common.core.result.ResultJSON;
import com.xiumu.generator.constants.Constants;
import com.xiumu.generator.entity.Database;
import com.xiumu.generator.exception.GenException;
import com.xiumu.generator.mapper.GenTableMapper;
import com.xiumu.generator.service.DatabaseService;
import com.xiumu.generator.service.GeneratorService;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 初始化项目接口
 *
 * @Author XiuMu
 * @Date 2022/8/10
 **/
@RestController
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private GenTableMapper genTableMapper;

    /**
     * 初始化项目
     *
     * @return
     */
    @GetMapping("/init")
    public ResultJSON init() {
        generatorService.init();
        return ResultJSON.success();
    }


    /**
     * 初始化一个数据源
     *
     * @return
     */
    @PostMapping("/create/datasource")
    public ResultJSON initDataSource(@RequestBody Database database) {
        databaseService.createDataSource(database);
        // 测试数据库是否可以连接
        DynamicDataSourceContextHolder.push(database.getDataSource());
        Integer integer = 0;
        try {
            integer = genTableMapper.countDatabaseByName(database.getDatabaseName());
        } catch (MyBatisSystemException exception) {
            // 连接失败，删除数据源
            DynamicDataSourceContextHolder.push(Constants.GENERATOR_DATASOURCE);
            databaseService.removeById(database);
            DynamicDataSourceContextHolder.clear();
            String message = exception.getMessage();
            if (message != null) {
                if (message.contains("The driver has not received any packets from the server")) {
                    throw new XiuMuException(GenException.DATABASE_NOT_CONNECT);
                } else if (message.contains("using password: YES")) {
                    throw new XiuMuException(GenException.DATABASE_ERROR_PASSWORD);
                }
            }
        }
        return integer > 0 ? ResultJSON.success() : ResultJSON.failure();
    }
}
