package com.xiumu.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.pojo.sys.entity.UserRole;
import com.xiumu.pojo.sys.dto.UserRoleDTO;
import com.xiumu.pojo.sys.query.UserRoleQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiumu.common.core.page.PageQuery;

import java.util.List;

/**
 * 用户角色关联 Service 接口
 *
 * @author XiuMu
 * @date 2022-07-23 01:07:42
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
    boolean updateById(UserRoleDTO userRoleDTO, String id);

    /**
     * 根据 id 逻辑删除
     *
     * @param id id
     * @return
     */
    boolean deleteById(String id);
}
