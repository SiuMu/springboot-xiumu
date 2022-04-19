package com.xiumu.springbootxiumu.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xiumu.springbootxiumu.manager.UserManager;
import com.xiumu.springbootxiumu.pojo.vo.ResultJSON;
import com.xiumu.springbootxiumu.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关 API
 * 需要登录访问
 */
@SaCheckLogin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManager userManager;

    /**
     * 获取用户的个人信息
     * @return
     */
    @GetMapping("/info")
    public ResultJSON getUserInfo(){
        UserVO userVO = userManager.getUserById(StpUtil.getLoginIdAsLong());
        return ResultJSON.success(userVO);
    }

}
