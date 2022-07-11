package com.xiumu.springbootxiumu.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.springbootxiumu.constant.XiuMuConst;
import com.xiumu.springbootxiumu.enums.YesNo;
import com.xiumu.springbootxiumu.exception.user.UserException;
import com.xiumu.springbootxiumu.mapper.UserMapper;
import com.xiumu.springbootxiumu.pojo.dto.UserDTO;
import com.xiumu.springbootxiumu.pojo.dto.UserLoginDTO;
import com.xiumu.springbootxiumu.pojo.entity.User;
import com.xiumu.springbootxiumu.pojo.query.UserQuery;
import com.xiumu.springbootxiumu.service.UserRoleService;
import com.xiumu.springbootxiumu.service.UserService;
import com.xiumu.springbootxiumu.utils.AssertUtil;
import com.xiumu.springbootxiumu.utils.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.xiumu.springbootxiumu.utils.BeanCopyUtil.INSTANCE;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username)
                .eq(User::getPassword, password)
                .eq(User::getDeleteFlag, YesNo.NO);
        return this.getOne(queryWrapper);
    }

    @Override
    public User userLogin(UserLoginDTO userLoginDTO) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, userLoginDTO.getUsername())
                .eq(User::getPassword, SecureUtil.md5(userLoginDTO.getPassword()));
        User user = this.getOne(queryWrapper);
        // 判断密码错误
        AssertUtil.notNull(user, UserException.PASSWD_ERROR);
        // 判断用户是否禁用
        AssertUtil.isFalse(user.getEnabled() == YesNo.NO, UserException.NOT_ENABLED);
        return user;
    }

    @Override
    public boolean userRegister(UserDTO userDTO) {
        // 先判断用户名是否被使用过
        User user = findByUsername(userDTO.getUsername());
        AssertUtil.isNull(user, UserException.EXITED);
        user = INSTANCE.userDTOToUser(userDTO);
        return this.save(user);
    }

    @Override
    public IPage<User> listPage(PageQuery<UserQuery, User> pageable) {
        return this.baseMapper.listPage(pageable, pageable.getCondition());
    }

    @Override
    @Transactional
    public boolean createUser(UserDTO userDTO) {
        User user = findByUsername(userDTO.getUsername());
        AssertUtil.isNull(user, UserException.EXITED);
        BeanUtil.copyProperties(userDTO, user);
        // 设置密码
        if (userDTO.getSetPassword() == YesNo.YES) {
            // 确定两次密码输入一致
            AssertUtil.isTrue(userDTO.getPassword().equals(userDTO.getConfirmPassword()), UserException.CONFIRM_PASSWORD_ERROR);
            user.setPassword(SecureUtil.md5(user.getPassword()));
        } else {
            // 设置默认密码
            user.setPassword(XiuMuConst.DEFAULT_PASSWORD);
        }

        this.save(user);
        return userRoleService.createBatchByUserIdAndRoleList(user.getId(), userDTO.getRoleList());
    }

    @Override
    @Transactional
    public boolean updateUserById(UserDTO userDTO, Long userId) {
        User user = this.getById(userId);
        AssertUtil.notNull(user, UserException.NOT_EXIT);
        BeanUtil.copyProperties(userDTO, user);
        user.setId(userId);
        // 设置密码
        if (userDTO.getSetPassword() == YesNo.YES) {
            // 确定两次密码输入一致
            AssertUtil.isTrue(userDTO.getPassword().equals(userDTO.getConfirmPassword()), UserException.CONFIRM_PASSWORD_ERROR);
            user.setPassword(SecureUtil.md5(user.getPassword()));
        }
        // 删除之前的角色，添加最新的角色
        userRoleService.deleteByUserId(userId);
        userRoleService.createBatchByUserIdAndRoleList(userId, userDTO.getRoleList());
        return this.updateById(user);
    }

    @Override
    @Transactional
    public boolean updateEnabled(Long userId, YesNo enabled) {
        User user = this.getById(userId);
        AssertUtil.notNull(user, UserException.NOT_EXIT);
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<User>().set(User::getEnabled, enabled).eq(User::getId, userId);
        return this.update(updateWrapper);
    }

    @Override
    public User findByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username);
        return getOne(queryWrapper);
    }
}
