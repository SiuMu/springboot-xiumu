package com.xiumu.springbootxiumu.config.satoken;

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.convert.Convert;
import com.xiumu.springbootxiumu.pojo.entity.Role;
import com.xiumu.springbootxiumu.service.AuthorityService;
import com.xiumu.springbootxiumu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 获取用户的角色集合
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthorityService authorityService;

    /**
     * 获取权限
     *
     * @return
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return authorityService.getAuthCodeByUserId(Convert.toLong(loginId));
    }

    /**
     * 获取用户角色
     *
     * @return
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<Role> roles = roleService.getByUserId(Convert.toLong(loginId));
        return roles.stream().map(Role::getRoleCode).collect(Collectors.toList());
    }
}
