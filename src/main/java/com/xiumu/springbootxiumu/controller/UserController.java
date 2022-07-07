package com.xiumu.springbootxiumu.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.xiumu.springbootxiumu.manager.UserManager;
import com.xiumu.springbootxiumu.pojo.dto.UserLoginDTO;
import com.xiumu.springbootxiumu.pojo.dto.UserRegisterDTO;
import com.xiumu.springbootxiumu.pojo.entity.User;
import com.xiumu.springbootxiumu.pojo.vo.ResultJSON;
import com.xiumu.springbootxiumu.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户相关 API
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManager userManager;

    /**
     * 登录接口
     *
     * @param userLoginDTO 登录传参
     * @return
     */
    @PostMapping("/login")
    public ResultJSON userLogin(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        User user = userManager.userLogin(userLoginDTO);
        StpUtil.login(user.getId());
        return ResultJSON.success(StpUtil.getTokenInfo().tokenValue);
    }

    /**
     * 注册接口
     *
     * @param userRegisterDTO 注册传参
     * @return
     */
    @PostMapping("/register")
    public ResultJSON userRegister(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {
        return ResultJSON.success(userManager.userRegister(userRegisterDTO));
    }

    /**
     * 获取用户的个人信息
     *
     * @return
     */
    @GetMapping("/info")
    public ResultJSON getUserInfo() {
        UserVO userVO = userManager.getUserById(StpUtil.getLoginIdAsLong());
        return ResultJSON.success(userVO);
    }

}
