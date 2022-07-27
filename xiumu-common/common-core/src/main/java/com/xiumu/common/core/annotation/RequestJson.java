package com.xiumu.common.core.annotation;

import com.xiumu.common.core.utils.HandlerRequestJsonArgumentResolver;

import java.lang.annotation.*;

/**
 * get 请求参数解析，用于接收复杂参数，复杂参数需要 base64 编码之后传输 <br/>
 * get 请求参数使用该注解就会使用自定义的参数解析器来解析复杂的参数
 * {@link HandlerRequestJsonArgumentResolver}
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestJson {

}
