package com.xiumu.springbootxiumu.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.springbootxiumu.manager.UserManager;
import com.xiumu.springbootxiumu.mapper.UserMapper;
import com.xiumu.springbootxiumu.pojo.entity.User;
import com.xiumu.springbootxiumu.utils.enums.YesNo;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl extends ServiceImpl<UserMapper, User> implements UserManager {

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username)
                .eq(User::getPassword, password)
                .eq(User::getDeleteFlag, YesNo.NO);
        return this.getOne(queryWrapper);
    }
}
