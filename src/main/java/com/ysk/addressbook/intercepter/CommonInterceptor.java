package com.ysk.addressbook.intercepter;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by lei on 18/04/2017.
 * Yes, you can.
 */
@Component
public class CommonInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("text/json;charset=UTF-8");
        return true;
    }

    static void writeCommonResult(HttpServletResponse response, JSON commonRet) {
        response.setContentType("text/json;charset=UTF-8");
        try (Writer writer = response.getWriter()) {
            writer.write(commonRet.toJSONString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        String requestToken = request.getHeader(Config.LOGIN_TOKEN);
//        if (Strings.isNullOrEmpty(requestToken)) {
//            return;
//        }
//        int uid = tokenService.extendTTL(requestToken);
//        userService.asyncUpdateActiveTime(uid);
    }
}
