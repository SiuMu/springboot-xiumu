package com.xiumu.springbootxiumu.config.satoken;

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.convert.Convert;
import com.xiumu.springbootxiumu.manager.AuthorityManager;
import com.xiumu.springbootxiumu.manager.RoleManager;
import com.xiumu.springbootxiumu.pojo.entity.Authority;
import com.xiumu.springbootxiumu.pojo.entity.Role;
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
    private RoleManager roleManager;

    @Autowired
    private AuthorityManager authorityManager;

    /**
     * 获取权限，该版本没有权限，返回null即可
     * @return
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<Authority> authorityList = authorityManager.getByUserId(Convert.toStr(loginId));
        return authorityList.stream().map(Authority::getAuthCode).collect(Collectors.toList());
    }

    /**
     * 获取用户角色
     * @return
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<Role> roles = roleManager.getByUserId(Convert.toStr(loginId));
        return roles.stream().map(Role::getRoleCode).collect(Collectors.toList());
    }
}
