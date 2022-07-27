package com.xiumu.config;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import com.xiumu.common.core.utils.HandlerRequestJsonArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 注册 Sa-Token 注解拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaAnnotationInterceptor());
//        registry.addInterceptor(new SaRouteInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/token");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new HandlerRequestJsonArgumentResolver());
//        WebMvcConfigurer.super.addArgumentResolvers(resolvers);
    }
}
