package com.xiumu.service.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.pojo.sys.dto.RoleDTO;
import com.xiumu.pojo.sys.entity.Role;
import com.xiumu.pojo.sys.query.RoleQuery;

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
    List<String> listRoleCodeByUserId(Long userId);

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
    boolean updateById(RoleDTO roleDTO, Long id);

    /**
     * 根据 id 逻辑删除
     *
     * @param id id
     * @return
     */
    boolean deleteById(Long id);

    /**
     * 通过 用户ID 查询用户的角色
     *
     * @param userId 用户ID
     * @return
     */
    List<Role> listByUserId(Long userId);

    /**
     * 根据编码查询角色
     *
     * @param roleCode 角色编码
     * @return
     */
    Role getByRoleCode(String roleCode);

    /**
     * 设置角色的权限
     *
     * @param id         角色 ID
     * @param authIdList 权限 ID
     * @return
     */
    boolean setAuth(Long id, List<Long> authIdList);
}
