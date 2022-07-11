package com.xiumu.springbootxiumu.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.springbootxiumu.exception.user.RoleException;
import com.xiumu.springbootxiumu.mapper.RoleMapper;
import com.xiumu.springbootxiumu.pojo.dto.RoleDTO;
import com.xiumu.springbootxiumu.pojo.entity.Role;
import com.xiumu.springbootxiumu.service.RoleAuthService;
import com.xiumu.springbootxiumu.service.RoleService;
import com.xiumu.springbootxiumu.utils.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleAuthService roleAuthService;

    @Override
    public List<Role> getByUserId(Long userId) {
        return this.baseMapper.selectRolesByUserId(userId);
    }

    @Override
    public Role getByRoleCode(String roleCode) {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<Role>().eq(Role::getRoleCode, roleCode);
        return this.getOne(queryWrapper);
    }

    @Override
    @Transactional
    public boolean createRole(RoleDTO roleDTO) {
        // 角色编码不能重复
        Role role = getByRoleCode(roleDTO.getRoleCode());
        AssertUtil.isNull(role, RoleException.CODE_EXIT);
        role = new Role();
        // 保存角色以及角色权限关联信息
        BeanUtil.copyProperties(roleDTO, role);
        this.save(role);
        return roleAuthService.createBatchByRoleIdAndAuthList(role.getId(), roleDTO.getAuthList());
    }

    @Override
    @Transactional
    public boolean updateRoleById(RoleDTO roleDTO, Long id) {
        Role role = this.getById(id);
        AssertUtil.notNull(role, RoleException.NOT_EXIT);
        BeanUtil.copyProperties(roleDTO, role);
        role.setId(id);
        // 删除之前的权限，添加最新的权限
        roleAuthService.deleteByRoleId(id);
        roleAuthService.createBatchByRoleIdAndAuthList(role.getId(), roleDTO.getAuthList());
        return this.updateById(role);
    }
}
