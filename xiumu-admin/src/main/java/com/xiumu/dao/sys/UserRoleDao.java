package com.xiumu.dao.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.pojo.sys.entity.UserRole;
import com.xiumu.pojo.sys.model.query.UserRoleQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户角色关联 Mapper 接口
 *
 * @author XiuMu
 * @date 2022-07-23 01:07:42
 */
@Repository
public interface UserRoleDao extends BaseMapper<UserRole> {

    /**
     * 分页查询
     *
     * @param query    分页条件
     * @param userRole 查询条件
     * @return
     */
    IPage<UserRole> selectPage(PageQuery<UserRoleQuery, UserRole> query, @Param("userRole") UserRoleQuery userRole);

    /**
     * 根据条件查询 用户角色关联
     *
     * @param userRole 查询条件
     * @return
     */
    List<UserRole> selectByUserRole(@Param("userRole") UserRoleQuery userRole);

}
