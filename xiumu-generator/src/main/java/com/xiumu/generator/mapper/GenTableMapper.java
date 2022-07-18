package com.xiumu.generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.generator.entity.GenTable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 表信息 mapper
 *
 * @Author XiuMu
 * @Date 2022/7/16
 **/
@Repository
public interface GenTableMapper extends BaseMapper<GenTable> {

    /**
     * 根据表名字查询表的信息
     *
     * @param tableName    表名称
     * @param databaseName 数据库名称
     * @return
     */
    GenTable selectGenTableByName(@Param("tableName") String tableName, @Param("databaseName") String databaseName);

    /**
     * 获取该数据库的所有表信息
     *
     * @param databaseName 数据库名称
     * @return
     */
    List<GenTable> selectAllByDatabaseName(String databaseName);
}
