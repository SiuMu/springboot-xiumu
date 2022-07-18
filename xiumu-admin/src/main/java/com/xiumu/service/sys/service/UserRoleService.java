package com.xiumu.service.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.pojo.sys.entity.UserRole;
import com.xiumu.pojo.sys.model.dto.UserRoleDTO;
import com.xiumu.pojo.sys.model.query.UserRoleQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiumu.common.core.page.PageQuery;

import java.util.List;

/**
 * service 层 方法命名遵循自解释原则，好的方法名可以直接简单明了的表示该方法的作用
 * 尽量少用 Wrapper 条件构造器，尤其是条件过多的时候，一定要将 sql 写到 xml 中，做到 sql 与代码之间的隔离
 * 简单查询可以使用 Wrapper 条件构造器
 *
 * 用户角色关联 Service 接口
 *
 * @author XiuMu
 * @date 2022-07-16 17:28:18
 */
public interface UserRoleService extends IService<UserRole> {

    /**
     * 分页查询
     *
     * @param pageQuery 分页条件
     * @return
     */
    IPage<UserRole> listPage(PageQuery<UserRoleQuery, UserRole> pageQuery);

    /**
     * 根据条件查询 用户角色关联
     *
     * @param userRole 查询条件
     * @return
     */
    List<UserRole> listByUserRole(UserRoleQuery userRole);

    /**
     * 创建 用户角色关联
     *
     * @param userRoleDTO userRole 信息
     * @return
     */
    boolean create(UserRoleDTO userRoleDTO);

    /**
     * 更新 用户角色关联
     *
     * @param userRoleDTO 更新内容
     * @param id 主键 ID
     * @return
     */
    boolean updateById(UserRoleDTO userRoleDTO, Long id);

    /**
     * 根据 id 逻辑删除
     *
     * @param id id
     * @return
     */
    boolean deleteById(Long id);
}
