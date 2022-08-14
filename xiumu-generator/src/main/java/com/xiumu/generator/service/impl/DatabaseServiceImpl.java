package com.xiumu.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.common.core.utils.AssertUtil;
import com.xiumu.generator.entity.Database;
import com.xiumu.generator.exception.GenException;
import com.xiumu.generator.mapper.DatabaseMapper;
import com.xiumu.generator.service.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author XiuMu
 * @Date 2022/8/11
 **/
@Service
public class DatabaseServiceImpl extends ServiceImpl<DatabaseMapper, Database> implements DatabaseService {

    @Override
    public void createDataSource(Database database) {
        LambdaQueryWrapper<Database> queryWrapper = new LambdaQueryWrapper<Database>()
                .eq(Database::getIpPort, database.getIpPort())
                .eq(Database::getDatabaseName, database.getDatabaseName())
                .last("limit 1");
        Database temp = getOne(queryWrapper);
        AssertUtil.isNull(temp, GenException.DATABASE_EXIST);
        database.setDataSource(database.getIpPort() + database.getDatabaseName());
        database.setCreateTime(new Date());
        database.setUpdateTime(new Date());
        this.save(database);
    }
}
