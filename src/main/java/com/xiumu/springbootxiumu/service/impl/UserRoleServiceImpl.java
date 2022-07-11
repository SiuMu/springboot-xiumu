package com.xiumu.springbootxiumu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.springbootxiumu.mapper.UserRoleMapper;
import com.xiumu.springbootxiumu.pojo.entity.UserRole;
import com.xiumu.springbootxiumu.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Override
    @Transactional
    public boolean createBatchByUserIdAndRoleList(Long userId, List<Long> roleList) {
        List<UserRole> userRoleList = new ArrayList<>();
        for (Long id : roleList) {
            userRoleList.add(new UserRole(userId, id));
        }
        return this.saveBatch(userRoleList);
    }

    @Override
    @Transactional
    public boolean deleteByUserId(Long userId) {
        LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, userId);
        return this.remove(queryWrapper);
    }

    @Override
    public List<UserRole> findByUserId(Long userId) {
        LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, userId);
        return this.list(queryWrapper);
    }

    @Override
    public List<Long> findRoleIdByUserId(Long userId) {
        List<UserRole> userRoleList = findByUserId(userId);
        return userRoleList.stream().map(UserRole::getRoleId).collect(Collectors.toList());
    }
}
