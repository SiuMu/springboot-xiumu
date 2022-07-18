package com.xiumu.service.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiumu.pojo.sys.entity.Role;
import com.xiumu.pojo.sys.model.dto.RoleDTO;
import com.xiumu.pojo.sys.model.query.RoleQuery;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import com.xiumu.common.core.page.PageQuery;

import java.util.List;

/**
 * dao 层方法命名尽量以 sql 语义命名，方法应当与业务无关
 * 插入 insertXXX
 * 更新 updateXXX
 * 查询 selectXXX
 * 删除 deleteXXX
 *
 * 角色 Mapper 接口
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:52
 */
@Repository
public interface RoleDao extends BaseMapper<Role> {

    /**
     * 分页查询
     * @param query 分页条件
     * @param role 查询条件
     * @return
     */
    IPage<Role> selectPage(PageQuery<RoleQuery, Role> query, @Param("role") RoleQuery role);

    /**
     * 根据条件查询 角色
     * @param role 查询条件
     * @return
     */
    List<Role> selectByRole(@Param("role") RoleQuery role);

    /**
     * 根据 ID 更新 权限信息
     *
     * @param id           ID
     * @param role 权限信息, 空字段则不更新
     * @return
     */
    boolean updateById(@Param("id") Long id, @Param("role") RoleDTO role);
}
