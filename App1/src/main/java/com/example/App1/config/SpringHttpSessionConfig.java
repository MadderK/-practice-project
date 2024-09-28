package com.example.App1.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

import java.util.concurrent.ConcurrentHashMap;

/**
 * session配置类文件，设置cookie的格式以及session的存储位置
 */
@Configuration
@EnableSpringHttpSession
public class SpringHttpSessionConfig {

    //读写cookie中的session id信息
    @Bean
    public CookieSerializer cookieSerializer(){
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("JSESSIONID");
        serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");
        serializer.setCookiePath("/");
        serializer.setUseHttpOnlyCookie(false);
        serializer.setCookieMaxAge(2*24*60*60);
        return serializer;
    }

    //session存放仓库
    @Bean
    public MapSessionRepository sessionRepository(){

        return new MapSessionRepository(new ConcurrentHashMap<>());

    }
}
