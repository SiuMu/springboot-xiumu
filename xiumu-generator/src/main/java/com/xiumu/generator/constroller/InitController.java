package com.xiumu.generator.constroller;

import com.xiumu.common.core.result.ResultJSON;
import com.xiumu.generator.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 初始化项目接口
 *
 * @Author XiuMu
 * @Date 2022/8/10
 **/
@RestController
public class InitController {

    @Autowired
    private GeneratorService generatorService;

    /**
     * 初始化项目
     *
     * @return
     */
    @GetMapping("/init")
    public ResultJSON init(){
        generatorService.init();
        return ResultJSON.success();
    }
}
