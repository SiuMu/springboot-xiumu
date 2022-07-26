package com.xiumu.controller.sys;

import cn.dev33.satoken.stp.StpUtil;
import com.xiumu.common.core.result.ResultJSON;
import com.xiumu.pojo.sys.dto.LoginDTO;
import com.xiumu.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Token Controller
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:37
 */
@Validated
@RestController
public class TokenController {

    @Autowired
    private UserService userService;

    /**
     * 登录接口，返回 token
     *
     * @param loginDTO 登录凭证
     * @return
     */
    @GetMapping("/token")
    public ResultJSON list(@Validated LoginDTO loginDTO) {
        return ResultJSON.success(userService.login(loginDTO));
    }

    /**
     * 退出登录
     *
     * @return
     */
    @GetMapping("/logout")
    public ResultJSON logout() {
        System.out.println("退出" + StpUtil.getSession());
        StpUtil.logout();
        return ResultJSON.success();
    }

    /**
     * 获取用户的信息，角色以及权限
     *
     * @return
     */
    @GetMapping("/userRoleAuth")
    public ResultJSON userRoleAuth() {
        return ResultJSON.success(userService.findUserRoleAuthVOByUserId(StpUtil.getLoginIdAsString()));
    }
}
