package com.xiumu.springbootxiumu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.springbootxiumu.enums.YesNo;
import com.xiumu.springbootxiumu.mapper.UserMapper;
import com.xiumu.springbootxiumu.pojo.entity.User;
import com.xiumu.springbootxiumu.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username)
                .eq(User::getPassword, password)
                .eq(User::getDeleteFlag, YesNo.NO);
        return this.getOne(queryWrapper);
    }

    @Override
    public User findUserByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username)
                .eq(User::getDeleteFlag, YesNo.NO);
        return this.getOne(queryWrapper);
    }

    @Override
    public boolean existByUsername(String username) {
        User user = findUserByUsername(username);
        return user == null;
    }
}
