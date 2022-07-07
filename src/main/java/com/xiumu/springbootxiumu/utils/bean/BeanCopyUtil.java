package com.xiumu.springbootxiumu.utils.bean;

import com.xiumu.springbootxiumu.pojo.dto.UserRegisterDTO;
import com.xiumu.springbootxiumu.pojo.entity.User;
import com.xiumu.springbootxiumu.pojo.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * bean 拷贝工具 MapStruct
 */
@Mapper
public interface BeanCopyUtil {

    BeanCopyUtil INSTANCE = Mappers.getMapper(BeanCopyUtil.class);

    UserVO userToUserVo(User user);

    User userRegisterToUser(UserRegisterDTO registerDTO);
}
