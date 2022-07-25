package com.xiumu.dao.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.pojo.sys.entity.User;
import com.xiumu.pojo.sys.query.UserQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户 Mapper 接口
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:37
 */
@Repository
public interface UserDao extends BaseMapper<User> {

    /**
     * 分页查询
     *
     * @param query 分页条件
     * @param user  查询条件
     * @return
     */
    IPage<User> selectPage(PageQuery<UserQuery, User> query, @Param("user") UserQuery user);

    /**
     * 根据条件查询 用户
     *
     * @param user 查询条件
     * @return
     */
    List<User> selectByUser(@Param("user") UserQuery user);

}
