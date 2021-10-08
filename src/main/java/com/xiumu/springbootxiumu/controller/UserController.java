package com.xiumu.springbootxiumu.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.xiumu.springbootxiumu.pojo.dto.UserLoginDTO;
import com.xiumu.springbootxiumu.pojo.vo.ResultJSON;
import com.xiumu.springbootxiumu.pojo.vo.UserVO;
import com.xiumu.springbootxiumu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录接口
     * @param userLoginDTO 登录传参
     * @return
     */
    @PostMapping("/login")
    public ResultJSON userLogin(@RequestBody UserLoginDTO userLoginDTO){
        Long userId = userService.userLogin(userLoginDTO);
        StpUtil.login(userId);
        return ResultJSON.success(StpUtil.getTokenInfo().tokenValue);
    }

    /**
     * 获取用户的个人信息
     * @return
     */
    @SaCheckLogin
    @GetMapping("/getUserInfo")
    public ResultJSON getUserInfo(){
        UserVO userVO = userService.getUserById(StpUtil.getLoginIdAsLong());
        return ResultJSON.success(userVO);
    }

    /**
     * 验证用户是否有 admin 角色
     * @return
     */
    @SaCheckRole("admin")
    @GetMapping("/verifyRole")
    public ResultJSON verifyRole(){
        // 测试 角色验证
        return ResultJSON.success();
    }




}
