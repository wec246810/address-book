package com.ysk.addressbook.config;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.ysk.addressbook.intercepter.CheckLoginInterceptor;
import com.ysk.addressbook.intercepter.CommonInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    private final CheckLoginInterceptor checkLoginInterceptor;
    //    private final CheckIPInterceptor checkIPInterceptor;
    private final CommonInterceptor commonInterceptor;
//    private final LoginUidArgumentResolver loginUidArgumentResolver;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter4 = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setFeatures(Feature.IgnoreNotMatch, Feature.IgnoreNotMatch);
        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNullNumberAsZero);
        converter4.setFastJsonConfig(config);
        converters.add(converter4);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonInterceptor);
        registry.addInterceptor(checkLoginInterceptor);
//        registry.addInterceptor(checkIPInterceptor);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        resolvers.add(loginUidArgumentResolver);
    }
}

