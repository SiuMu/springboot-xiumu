package com.xiumu.springbootxiumu;

import com.xiumu.springbootxiumu.pojo.entity.User;
import com.xiumu.springbootxiumu.pojo.vo.UserVO;
import com.xiumu.springbootxiumu.utils.bean.BeanCopyUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootXiumuApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("xiumu");
        user.setPhone("1893498741");
        UserVO userVO = BeanCopyUtil.INSTANCE.userToUserVo(user);
        System.out.println(userVO);
    }

}
