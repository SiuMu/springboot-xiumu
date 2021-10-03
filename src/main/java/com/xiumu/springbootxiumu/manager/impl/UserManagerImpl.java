package com.xiumu.springbootxiumu.manager.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.springbootxiumu.manager.UserManager;
import com.xiumu.springbootxiumu.mapper.UserMapper;
import com.xiumu.springbootxiumu.pojo.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl extends ServiceImpl<UserMapper, User> implements UserManager {
}
