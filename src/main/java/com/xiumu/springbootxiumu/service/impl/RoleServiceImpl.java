package com.xiumu.springbootxiumu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.springbootxiumu.mapper.RoleMapper;
import com.xiumu.springbootxiumu.pojo.entity.Role;
import com.xiumu.springbootxiumu.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public List<Role> getByUserId(String userId) {
        return this.baseMapper.selectRolesByUserId(userId);
    }
}
