package com.xiumu.springbootxiumu.manager.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.springbootxiumu.manager.RoleManager;
import com.xiumu.springbootxiumu.mapper.RoleMapper;
import com.xiumu.springbootxiumu.pojo.entity.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleManagerImpl extends ServiceImpl<RoleMapper, Role> implements RoleManager {

}
