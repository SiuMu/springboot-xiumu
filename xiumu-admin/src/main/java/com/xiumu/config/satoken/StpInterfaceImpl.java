package com.xiumu.config.satoken;

import cn.dev33.satoken.stp.StpInterface;
import com.xiumu.service.sys.AuthorityService;
import com.xiumu.service.sys.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 获取用户的角色集合
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private RoleService roleService;

    /**
     * 获取权限
     *
     * @return
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return null;
    }

    /**
     * 获取用户角色
     *
     * @return
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return null;
    }
}
