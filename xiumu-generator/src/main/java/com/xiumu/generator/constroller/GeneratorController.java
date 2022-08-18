package com.xiumu.generator.constroller;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.xiumu.common.core.exception.base.XiuMuException;
import com.xiumu.common.core.result.ResultJSON;
import com.xiumu.generator.constants.Constants;
import com.xiumu.generator.entity.CodeConfig;
import com.xiumu.generator.entity.Database;
import com.xiumu.generator.entity.GenTable;
import com.xiumu.generator.exception.GenException;
import com.xiumu.generator.mapper.GenTableMapper;
import com.xiumu.generator.service.CodeTemplateService;
import com.xiumu.generator.service.DatabaseService;
import com.xiumu.generator.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private CodeTemplateService codeTemplateService;

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
    @PostMapping("/datasource")
    public ResultJSON initDataSource(@RequestBody Database database) {
        databaseService.createDataSource(database);
        Integer integer = 0;
        try {
            generatorService.addDatasource(database);
            // 测试数据库是否可以连接
            DynamicDataSourceContextHolder.push(database.getDataSource());
            integer = genTableMapper.countDatabaseByName(database.getDatabaseName());
        } catch (Exception exception) {
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

    /**
     * 查询所有的数据源
     *
     * @return
     */
    @GetMapping("/database")
    public ResultJSON database() {
        DynamicDataSourceContextHolder.push(Constants.GENERATOR_DATASOURCE);
        List<Database> databaseList = databaseService.list();
        DynamicDataSourceContextHolder.clear();
        return ResultJSON.success(databaseList);
    }

    /**
     * 查询该数据源的所有表信息
     *
     * @return
     */
    @GetMapping("/database/{id}/table")
    public ResultJSON table(@PathVariable String id) {
        Database database = databaseService.getById(id);
        generatorService.addDatasource(database);
        DynamicDataSourceContextHolder.push(database.getDataSource());
        List<GenTable> tables = genTableMapper.selectAllByDatabaseName(database.getDatabaseName());
        DynamicDataSourceContextHolder.clear();
        return ResultJSON.success(tables);
    }

    /**
     * 查询所有的模板
     *
     * @return
     */
    @GetMapping("/template")
    public ResultJSON template() {
        return ResultJSON.success(codeTemplateService.list());
    }



    /**
     * 根据模板生成代码
     *
     * @return
     */
    @PostMapping("/code")
    public ResultJSON createCode(@RequestBody CodeConfig config) {
        return ResultJSON.success(generatorService.createCode(config));
    }


}
