package com.xiumu.dao.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.pojo.sys.entity.Authority;
import com.xiumu.pojo.sys.query.AuthorityQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限 Mapper 接口
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:15
 */
@Repository
public interface AuthorityDao extends BaseMapper<Authority> {

    /**
     * 分页查询
     *
     * @param query     分页条件
     * @param authority 查询条件
     * @return
     */
    IPage<Authority> selectPage(PageQuery<AuthorityQuery, Authority> query, @Param("authority") AuthorityQuery authority);

    /**
     * 根据条件查询 权限
     *
     * @param authority 查询条件
     * @return
     */
    List<Authority> selectByAuthority(@Param("authority") AuthorityQuery authority);

    /**
     * 根据角色ID获取权限
     *
     * @param roleId 角色ID
     * @return
     */
    List<Authority> selectByRoleId(Long roleId);

    /**
     * 根据用户ID 查询所有的权限
     *
     * @param userId 用户
     * @return
     */
    List<Authority> selectByUserId(Long userId);
}
