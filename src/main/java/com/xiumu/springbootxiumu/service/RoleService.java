package com.xiumu.springbootxiumu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.springbootxiumu.pojo.dto.RoleDTO;
import com.xiumu.springbootxiumu.pojo.entity.Role;

import java.util.List;


public interface RoleService extends IService<Role> {

    /**
     * 根据用户id获取所有角色
     *
     * @param userId 用户ID
     * @return
     */
    List<Role> getByUserId(Long userId);


    /**
     * 根据角色编码获取角色
     *
     * @param roleCode 角色编码
     * @return
     */
    Role getByRoleCode(String roleCode);

    /**
     * 添加角色
     *
     * @param roleDTO 角色信息
     * @return
     */
    boolean createRole(RoleDTO roleDTO);

    /**
     * 更新角色信息
     *
     * @param roleDTO 角色信息
     * @param id      角色ID
     * @return
     */
    boolean updateRoleById(RoleDTO roleDTO, Long id);
}
