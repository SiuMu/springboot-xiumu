package com.xiumu.springbootxiumu.config.satoken;

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.convert.Convert;
import com.xiumu.springbootxiumu.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * 获取用户的角色集合
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private UserManager userManager;

    /**
     * 获取权限，该版本没有权限，返回null即可
     * @return
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return null;
    }

    /**
     * 获取用户角色
     * @return
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 获取用户的角色
        List<String> roleList = new ArrayList<>();

        roleList.add(userManager.getById(Convert.toLong(loginId)).getRoleCode());

        return roleList;
    }
}
