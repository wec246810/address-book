package com.ysk.addressbook.config;

import com.ysk.addressbook.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class InterceptorConfig implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(InterceptorConfig.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 进入controller层之前拦截请求,将token放入redis之中
     *
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        log.info("---------------------开始进入请求地址拦截----------------------------");
        //检查用户是否已登录，如果已经登录，则返回true，否则返回false；
        String token=HttpUtils.getCookieByName(request,"token").getValue();
        System.out.println(stringRedisTemplate+"*-/-*/-*/*-/-*/-*/");
        if(token!=null){
            if(stringRedisTemplate.opsForValue().get(token)!=null){
                log.info("学生学号---------------->"+stringRedisTemplate.opsForValue().get(HttpUtils.getCookieByName(request,"token")));
                return true;
            }
        }
        return   false;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("--------------处理请求完成后视图渲染之前的处理操作---------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("---------------视图渲染之后的操作-------------------------0");
    }
}