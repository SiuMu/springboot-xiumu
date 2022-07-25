package com.xiumu.service.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.pojo.sys.entity.Role;
import com.xiumu.pojo.sys.model.dto.RoleDTO;
import com.xiumu.pojo.sys.model.query.RoleQuery;

import java.util.List;

/**
 * 角色 Service 接口
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:52
 */
public interface RoleService extends IService<Role> {

    /**
     * 分页查询
     *
     * @param pageQuery 分页条件
     * @return
     */
    IPage<Role> listPage(PageQuery<RoleQuery, Role> pageQuery);

    /**
     * 根据条件查询 角色
     *
     * @param role 查询条件
     * @return
     */
    List<Role> listByRole(RoleQuery role);

    /**
     * 根据 用户ID 查询角色编码
     *
     * @param userId 用户ID
     * @return
     */
    List<String> listRoleCodeByUserId(String userId);

    /**
     * 创建 角色
     *
     * @param roleDTO role 信息
     * @return
     */
    boolean create(RoleDTO roleDTO);

    /**
     * 更新 角色
     *
     * @param roleDTO 更新内容
     * @param id      主键 ID
     * @return
     */
    boolean updateById(RoleDTO roleDTO, String id);

    /**
     * 根据 id 逻辑删除
     *
     * @param id id
     * @return
     */
    boolean deleteById(String id);
}
