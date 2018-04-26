package com.ysk.addressbook.intercepter;

import com.google.common.base.Strings;
import com.ysk.addressbook.annotation.CheckLogin;
import com.ysk.addressbook.config.Config;
import com.ysk.addressbook.service.TokenService;
import com.ysk.addressbook.util.CookieUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述
 * Created by Y.S.K on 2018/4/17 16:34
 */
@Component
@RequiredArgsConstructor
@Log4j2
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {
    private final TokenService tokenService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!HandlerMethod.class.isAssignableFrom(handler.getClass())) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (!handlerMethod.hasMethodAnnotation(CheckLogin.class)) {
            return true;
        }
        String token = CookieUtil.getCookie(request, Config.TOKEN);
        if (Strings.isNullOrEmpty(token)) {
//            CommonInterceptor.writeCommonResult(response, RetService.NOT_LOGIN_ERR);
            response.sendRedirect("login");
            return false;
        }
        String uid = tokenService.checkLogin(token);
        if (Strings.isNullOrEmpty(uid)) {
//            CommonInterceptor.writeCommonResult(response, RetService.NOT_LOGIN_ERR);
            response.sendRedirect("login");
            return false;
        }
        return true;
    }
}
