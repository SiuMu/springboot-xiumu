package com.xiumu.springbootxiumu.manager;

import com.xiumu.springbootxiumu.exception.BaseException;
import com.xiumu.springbootxiumu.exception.BizException;
import com.xiumu.springbootxiumu.pojo.dto.UserLoginDTO;
import com.xiumu.springbootxiumu.pojo.dto.UserRegisterDTO;
import com.xiumu.springbootxiumu.pojo.entity.User;
import com.xiumu.springbootxiumu.pojo.vo.UserVO;
import com.xiumu.springbootxiumu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.xiumu.springbootxiumu.utils.BeanCopyUtil.INSTANCE;

@Service
public class UserManager {

    @Autowired
    private UserService userService;

    /**
     * 用户登录，成功则返回用户ID
     * @param userLoginDTO  登录传参
     * @return
     */
    public String userLogin(UserLoginDTO userLoginDTO){
        User user = userService.findUserByUsernameAndPassword(userLoginDTO.getUsername(), userLoginDTO.getPassword());

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
        User user = userService.getById(id);
        return INSTANCE.userToUserVo(user);
    }

    /**
     * 用户注册
     * @param userRegisterDTO 注册信息
     * @return
     */
    public boolean userRegister(UserRegisterDTO userRegisterDTO) {
        // 先判断用户名是否被使用过
        if (userService.existByUsername(userRegisterDTO.getUsername())) {
            throw new BizException(BaseException.REPEAT_USERNAME);
        }
        User user = INSTANCE.userRegisterToUser(userRegisterDTO);
        return userService.save(user);
    }
}
