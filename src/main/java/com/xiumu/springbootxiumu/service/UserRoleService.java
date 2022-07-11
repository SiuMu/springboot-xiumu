package com.xiumu.springbootxiumu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.springbootxiumu.pojo.entity.UserRole;

import java.util.List;

public interface UserRoleService extends IService<UserRole> {

    /**
     * 给用户添加角色
     *
     * @param userId   用户ID
     * @param roleList 角色ids
     * @return
     */
    boolean createBatchByUserIdAndRoleList(Long userId, List<Long> roleList);

    /**
     * 删除该用户下的角色
     *
     * @param userId 用户ID
     * @return
     */
    boolean deleteByUserId(Long userId);


    /**
     * 根据用户ID 查询
     *
     * @param userId 用户ID
     * @return
     */
    List<UserRole> findByUserId(Long userId);

    /**
     * 根据用户ID查询该用户的角色ID
     *
     * @param userId 用户ID
     * @return
     */
    List<Long> findRoleIdByUserId(Long userId);
}
