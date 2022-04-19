package com.xiumu.springbootxiumu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.springbootxiumu.pojo.entity.User;


public interface UserService extends IService<User> {

    /**
     * 根据用户名和密码查找用户信息
     * @param username  用户名
     * @param password  密码
     * @return
     */
    User findUserByUsernameAndPassword(String username, String password);


    /**
     * 根据用户名查找用户信息
     * @param username  用户名
     * @return
     */
    User findUserByUsername(String username);

    /**
     * 查询该用户名是否存在
     * @param username 用户名
     * @return
     */
    boolean existByUsername(String username);
}
