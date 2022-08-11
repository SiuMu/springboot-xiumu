package com.xiumu.generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.generator.entity.CodeTemplate;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 代码模板信息表
 *
 * @Author XiuMu
 * @Date 2022/8/11
 **/
@Repository
public interface CodeTemplateMapper extends BaseMapper<CodeTemplate> {

    /**
     * 创建表结构
     *
     * @return
     */
    @Update("create table xiumu_code_template\n" +
            "(\n" +
            "    id              bigint                             not null\n" +
            "        primary key,\n" +
            "    template_name    varchar(128)                       null ,\n" +
            "    template_content text                               null ,\n" +
            "    language        tinyint                            null ,\n" +
            "    create_time     datetime                           null ,\n" +
            "    update_time     datetime                           null  \n" +
            ")")
    Integer createCodeTemplate();

}
