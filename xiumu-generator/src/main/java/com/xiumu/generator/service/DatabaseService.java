package com.xiumu.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.generator.entity.Database;

/**
 * @Author XiuMu
 * @Date 2022/8/11
 **/
public interface DatabaseService extends IService<Database> {

    /**
     * 创建一个数据库连接，并记录到数据库中
     *
     * @param database 数据库连接
     */
    void createDataSource(Database database);

}
