package com.universe.family.config;

import com.universe.family.interceptor.AuthesInterceptor;
import com.universe.family.resolvers.CurrentMemberResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * 配置类，增加自定义拦截器和解析器
 * @see org.springframework.web.method.support.HandlerMethodArgumentResolver
 * @see com.universe.family.interceptor.AuthesInterceptor
 * @author ScienJus
 * @date 2015/7/30.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private AuthesInterceptor authesInterceptor;

    @Autowired
    private CurrentMemberResolver currentMemberResolver;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authesInterceptor);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentMemberResolver);
    }
}
