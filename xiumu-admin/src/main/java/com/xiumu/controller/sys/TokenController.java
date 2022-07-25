package com.xiumu.controller.sys;

import com.xiumu.common.core.result.ResultJSON;
import com.xiumu.pojo.sys.model.dto.LoginDTO;
import com.xiumu.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResultJSON list(@Validated @RequestBody LoginDTO loginDTO) {
        return ResultJSON.success(userService.login(loginDTO));
    }
}
