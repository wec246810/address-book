package com.ysk.addressbook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/**").excludePathPatterns("/css/**").excludePathPatterns("/img/**").excludePathPatterns("/js/**")
        .excludePathPatterns("/login").excludePathPatterns("/check-user");
    }
}