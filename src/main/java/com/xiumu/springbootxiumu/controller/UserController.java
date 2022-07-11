package com.xiumu.springbootxiumu.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.xiumu.springbootxiumu.constant.XiuMuConst;
import com.xiumu.springbootxiumu.exception.user.UserException;
import com.xiumu.springbootxiumu.pojo.dto.UserDTO;
import com.xiumu.springbootxiumu.pojo.dto.UserLoginDTO;
import com.xiumu.springbootxiumu.pojo.entity.User;
import com.xiumu.springbootxiumu.pojo.vo.ResultJSON;
import com.xiumu.springbootxiumu.pojo.vo.UserVO;
import com.xiumu.springbootxiumu.service.UserService;
import com.xiumu.springbootxiumu.utils.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户相关 API
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录接口
     *
     * @param userLoginDTO 登录传参
     * @return
     */
    @PostMapping("/login")
    public ResultJSON userLogin(@Validated @RequestBody UserLoginDTO userLoginDTO) {
        User user = userService.findUserByUsernameAndPassword(userLoginDTO.getUsername(), userLoginDTO.getPassword());
        AssertUtil.notNull(user, UserException.PASSWD_ERROR);
        StpUtil.login(user.getId());
        StpUtil.getSession().set(XiuMuConst.USERNAME, user.getUsername());
        return ResultJSON.success(StpUtil.getTokenInfo().tokenValue);
    }

    /**
     * 注册接口
     *
     * @param userDTO 注册传参
     * @return
     */
    @PostMapping("/register")
    public ResultJSON userRegister(@Valid @RequestBody UserDTO userDTO) {
        return ResultJSON.success(userService.userRegister(userDTO));
    }

    /**
     * 获取用户的个人信息
     *
     * @return
     */
    @GetMapping("/info")
    public ResultJSON getUserInfo() {
        UserVO userVO = new UserVO();
        return ResultJSON.success(userVO);
    }

}
