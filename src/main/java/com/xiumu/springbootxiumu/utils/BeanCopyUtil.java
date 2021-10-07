package com.xiumu.springbootxiumu.utils;

import com.xiumu.springbootxiumu.pojo.entity.User;
import com.xiumu.springbootxiumu.pojo.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * bean拷贝工具MapStruct
 */
@Mapper
public interface BeanCopyUtil {

    BeanCopyUtil INSTANCE = Mappers.getMapper(BeanCopyUtil.class);

    UserVO userToUserVo(User user);
}
