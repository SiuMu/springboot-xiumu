package com.xiumu.springbootxiumu.manager;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.springbootxiumu.pojo.entity.User;


public interface UserManager extends IService<User> {

    /**
     * 根据用户名和密码查找用户信息
     * @param username  用户名
     * @param password  密码
     * @return
     */
    User findUserByUsernameAndPassword(String username, String password);

}
