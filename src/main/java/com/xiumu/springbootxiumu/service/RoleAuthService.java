package com.xiumu.springbootxiumu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.springbootxiumu.pojo.entity.RoleAuth;

import java.util.List;

/**
 * @author xiumu
 */
public interface RoleAuthService extends IService<RoleAuth> {
    /**
     * 根据角色ID 查询该角色下的所有权限ID
     *
     * @param roleId 角色ID
     * @return
     */
    List<Long> findAuthIdByRoleId(Long roleId);


    /**
     * 根据角色ID 查询
     *
     * @param roleId 角色ID
     * @return
     */
    List<RoleAuth> findByRoleId(Long roleId);

    /**
     * 给角色分配权限
     *
     * @param roleId   角色ID
     * @param authList 权限ids
     * @return
     */
    boolean createBatchByRoleIdAndAuthList(Long roleId, List<Long> authList);

    /**
     * 删除该角色下的权限
     *
     * @param roleId 角色ID
     * @return
     */
    boolean deleteByRoleId(Long roleId);

}
