package com.xiumu.generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.generator.entity.Database;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 代码模板信息表
 *
 * @Author XiuMu
 * @Date 2022/8/11
 **/
@Repository
public interface DatabaseMapper extends BaseMapper<Database> {

    /**
     * 创建表结构
     *
     * @return
     */
    @Update("create table xiumu_database\n" +
            "(\n" +
            "    id            bigint       not null\n" +
            "        primary key,\n" +
            "    database_name varchar(64) null,\n" +
            "    database_type tinyint      null,\n" +
            "    data_source   varchar(64)  null,\n" +
            "    ip_port       varchar(64)  null,\n" +
            "    username      varchar(64)  null,\n" +
            "    password      varchar(64)  null,\n" +
            "    create_time   datetime     null,\n" +
            "    update_time   datetime     null\n" +
            ")")
    Integer createDatabase();
}
