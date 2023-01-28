package com.xiumu.service.sys.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.dao.sys.UserRoleDao;
import com.xiumu.pojo.sys.entity.UserRole;
import com.xiumu.service.sys.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户角色关联 Service 业务层处理
 *
 * @author XiuMu
 * @date 2022-07-23 01:07:42
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements UserRoleService {

    @Override
    public boolean deleteByUserId(String userId) {
        return remove(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, userId));
    }
}
