package com.xiumu.springbootxiumu.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.xiumu.springbootxiumu.manager.UserManager;
import com.xiumu.springbootxiumu.pojo.dto.UserLoginDTO;
import com.xiumu.springbootxiumu.pojo.vo.ResultJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 账号登录注册相关 API
 * 不需要登录访问
 */

@RestController
@RequestMapping("/user")
public class AccountController {

    @Autowired
    private UserManager userManager;

    /**
     * 登录接口
     * @param userLoginDTO 登录传参
     * @return
     */
    @PostMapping("/login")
    public ResultJSON userLogin(@Valid @RequestBody UserLoginDTO userLoginDTO){
        String userId = userManager.userLogin(userLoginDTO);
        StpUtil.login(userId);
        return ResultJSON.success(StpUtil.getTokenInfo().tokenValue);
    }
}
