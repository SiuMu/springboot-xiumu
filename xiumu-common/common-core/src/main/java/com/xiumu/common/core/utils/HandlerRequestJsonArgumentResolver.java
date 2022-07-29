package com.xiumu.common.core.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.json.JSONUtil;
import com.xiumu.common.core.annotation.RequestJson;
import com.xiumu.common.core.exception.base.XiuMuException;
import com.xiumu.common.core.exception.sys.SysException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义参数解析器，请求参数使用该注解 {@link RequestJson} 就会使用以下解析方式。
 * 为了解决 get 请求无法传递复杂参数, 又不能将参数放入请求体中的问题。
 * 说明：将参数序列化成 json，再经过 Base64 编码之后放在 url 上传输
 * 例如：http://localhost:8080/user/page?eyJjdXJyZW50IjoxLCJzaXplIjoxMCwidG90YWwiaG9uZSI6IiJ9fQ==
 */
@Slf4j
public class HandlerRequestJsonArgumentResolver implements HandlerMethodArgumentResolver {

    /**
     * 该方法判断是否要使用该参数解析器。这里我们就判断 有没有使用 @RequestJson 注解来判断是否使用该解析器
     * 如果返回 true 就运行 resolveArgument 方法来解析参数
     * 如果返回 false 使用其他参数解析器来解析参数，springframework 有很多参数解析器
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestJson.class);
    }

    /**
     * 该方法真正用来解析参数。
     * 先使用 Hutool 的 Base64 工具将 json 字符串解析出来
     * 再使用 Hutool 的 JSONUtil 工具将 json 转成 Bean 对象
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        try {
            String json = Base64.decodeStr(request.getQueryString());
            return JSONUtil.toBean(json, parameter.getGenericParameterType(),false);
        } catch (Exception e) {
            log.error("请求参数解析失败，请检查！" + e.getMessage());
            throw new XiuMuException(SysException.SERVE_FAIL);
        }
    }
}
