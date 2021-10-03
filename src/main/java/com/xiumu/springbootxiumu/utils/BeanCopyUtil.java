package com.xiumu.springbootxiumu.utils;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * bean拷贝工具MapStruct
 */
@Mapper
public interface BeanCopyUtil {

    BeanCopyUtil INSTANCE = Mappers.getMapper(BeanCopyUtil.class);

}
