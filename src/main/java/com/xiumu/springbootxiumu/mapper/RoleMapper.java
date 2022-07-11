package com.xiumu.springbootxiumu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.springbootxiumu.pojo.entity.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户ID查询用户所拥有的角色
     *
     * @param userId 用户ID
     * @return
     */
    List<Role> selectRolesByUserId(Long userId);
}
