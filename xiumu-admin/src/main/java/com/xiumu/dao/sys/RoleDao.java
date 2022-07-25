package com.xiumu.dao.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.pojo.sys.entity.Role;
import com.xiumu.pojo.sys.query.RoleQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色 Mapper 接口
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:52
 */
@Repository
public interface RoleDao extends BaseMapper<Role> {

    /**
     * 分页查询
     *
     * @param query 分页条件
     * @param role  查询条件
     * @return
     */
    IPage<Role> selectPage(PageQuery<RoleQuery, Role> query, @Param("role") RoleQuery role);

    /**
     * 根据条件查询 角色
     *
     * @param role 查询条件
     * @return
     */
    List<Role> selectByRole(@Param("role") RoleQuery role);

    /**
     * 根据 用户ID 查询用户所拥有的角色
     *
     * @param userId 用户ID
     * @return
     */
    List<Role> selectByUserId(String userId);

}
