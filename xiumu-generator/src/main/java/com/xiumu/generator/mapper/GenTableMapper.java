package com.xiumu.generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.generator.entity.GenTable;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
    @Select("select TABLE_NAME, TABLE_COMMENT from information_schema.TABLES where TABLE_NAME = #{tableName} and TABLE_SCHEMA = #{databaseName}")
    GenTable selectGenTableByName(@Param("tableName") String tableName, @Param("databaseName") String databaseName);

    /**
     * 获取该数据库的所有表信息
     *
     * @param databaseName 数据库名称
     * @return
     */
    @Select("select TABLE_NAME, TABLE_COMMENT from information_schema.TABLES where TTABLE_SCHEMA = #{databaseName}")
    List<GenTable> selectAllByDatabaseName(String databaseName);

    /**
     * 查询 databaseName 数据库的数量
     *
     * @param databaseName 数据库名称
     * @return
     */
    @Select("select count(*) from information_schema.SCHEMATA where SCHEMA_NAME = #{databaseName}")
    Integer countDatabaseByName(String databaseName);

    /**
     * 查询 数据库的中 tableName 表的数量
     *
     * @param tableName    表名称
     * @return
     */
    @Select("select count(*) from information_schema.TABLES where TABLE_SCHEMA = #{databaseName}")
    Integer countTableByName(@Param("tableName") String tableName);
}
