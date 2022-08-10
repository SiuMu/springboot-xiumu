package com.xiumu.generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.generator.entity.GenTableColumn;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 列信息 mapper
 *
 * @Author XiuMu
 * @Date 2022/7/16
 **/
@Repository
public interface GenTableColumnMapper extends BaseMapper<GenTableColumn> {

    /**
     * 根据表名字查询表的信息
     *
     * @param tableName    表名称
     * @param databaseName 数据库名称
     * @return
     */
    @Select("select COLUMN_NAME, DATA_TYPE, IS_NULLABLE, COLUMN_COMMENT from information_schema.COLUMNS where TABLE_NAME = #{tableName} and TABLE_SCHEMA = #{databaseName} order by ORDINAL_POSITION")
    List<GenTableColumn> selectTableColumnByName(@Param("tableName") String tableName, @Param("databaseName") String databaseName);
}
