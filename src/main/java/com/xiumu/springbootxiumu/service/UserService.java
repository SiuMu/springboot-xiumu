package com.xiumu.springbootxiumu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.springbootxiumu.enums.YesNo;
import com.xiumu.springbootxiumu.pojo.dto.UserDTO;
import com.xiumu.springbootxiumu.pojo.dto.UserLoginDTO;
import com.xiumu.springbootxiumu.pojo.entity.User;
import com.xiumu.springbootxiumu.pojo.query.UserQuery;
import com.xiumu.springbootxiumu.utils.PageQuery;


public interface UserService extends IService<User> {

    /**
     * 根据用户名和密码查找用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User findUserByUsernameAndPassword(String username, String password);

    /**
     * 验证用户登录,并返回用户信息
     *
     * @param userLoginDTO 登录传参
     * @return
     */
    User userLogin(UserLoginDTO userLoginDTO);

    /**
     * 分页查询
     *
     * @param pageable 分页条件
     * @return
     */
    IPage<User> listPage(PageQuery<UserQuery, User> pageable);

    /**
     * 新增用户
     *
     * @param userDTO 用户信息
     * @return
     */
    boolean createUser(UserDTO userDTO);

    /**
     * 根据ID修改用户
     *
     * @param userDTO 用户信息
     * @param userId  用户ID
     * @return
     */
    boolean updateUserById(UserDTO userDTO, Long userId);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return
     */
    User findByUsername(String username);

    /**
     * 设置用户的启用/禁用
     *
     * @param userId  用户ID
     * @param enabled 是否启用
     * @return
     */
    boolean updateEnabled(Long userId, YesNo enabled);

    /**
     * 用户注册
     *
     * @param userDTO 注册信息
     * @return
     */
    boolean userRegister(UserDTO userDTO);
}
