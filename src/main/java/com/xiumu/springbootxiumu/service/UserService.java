package com.xiumu.springbootxiumu.service;

import com.xiumu.springbootxiumu.exception.BaseException;
import com.xiumu.springbootxiumu.exception.BizException;
import com.xiumu.springbootxiumu.manager.UserManager;
import com.xiumu.springbootxiumu.pojo.dto.UserLoginDTO;
import com.xiumu.springbootxiumu.pojo.entity.User;
import com.xiumu.springbootxiumu.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.xiumu.springbootxiumu.utils.BeanCopyUtil.INSTANCE;

@Service
public class UserService {

    @Autowired
    private UserManager userManager;

    /**
     * 用户登录，成功则返回用户ID
     * @param userLoginDTO  登录传参
     * @return
     */
    public String userLogin(UserLoginDTO userLoginDTO){
        User user = userManager.findUserByUsernameAndPassword(userLoginDTO.getUsername(), userLoginDTO.getPassword());

        if (user == null){
            throw new BizException(BaseException.LOGIN_FAIL);
        }

        return user.getId();
    }

    /**
     * 根据用户ID获取用户的个人信息
     * @param id 用户ID
     * @return
     */
    public UserVO getUserById(Long id) {
        User user = userManager.getById(id);
        return INSTANCE.userToUserVo(user);
    }
}
