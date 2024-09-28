package com.example.App1.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.App1.interceptor.UserInterceptor;

/**
 * 拦截器管理
 */

@Configuration
public class AppConfigurer implements WebMvcConfigurer {

    @Autowired
    private UserInterceptor interceptor;

    //有四个无需执行拦截的页面
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(interceptor).addPathPatterns("/**")
                .excludePathPatterns("/app/login")
                .excludePathPatterns("/app/authenticate")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/error");
    }
}
