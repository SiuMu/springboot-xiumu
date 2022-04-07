package com.xiumu.springbootxiumu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.springbootxiumu.pojo.entity.Role;

import java.util.List;


public interface RoleService extends IService<Role> {

    /**
     * 根据用户id获取所有角色
     * @param userId 用户ID
     * @return
     */
    List<Role> getByUserId(String userId);
}
