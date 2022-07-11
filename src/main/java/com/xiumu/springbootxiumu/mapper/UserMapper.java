package com.xiumu.springbootxiumu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiumu.springbootxiumu.pojo.entity.User;
import com.xiumu.springbootxiumu.pojo.query.UserQuery;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    /**
     * 分页查询
     *
     * @param pageable 分页条件
     * @param user     查询条件
     * @return
     */
    IPage<User> listPage(Page<User> pageable, @Param("user") UserQuery user);
}
