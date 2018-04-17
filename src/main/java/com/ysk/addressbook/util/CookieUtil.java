package com.ysk.addressbook.util;

import lombok.extern.log4j.Log4j2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述
 * Created by Y.S.K on 2018/4/8 20:40
 */
@Log4j2
public class CookieUtil {

    private CookieUtil() {
    }

    /**
     * 添加cookie
     *
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }

    /**
     * 删除cookie
     *
     * @param response
     * @param name
     */
    public static void removeCookie(HttpServletResponse response, String name) {
        Cookie uid = new Cookie(name, null);
        uid.setPath("/");
        uid.setMaxAge(0);
        response.addCookie(uid);
    }

    /**
     * 获取cookie值
     *
     * @param request
     * @return
     */
    public static String getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
      //  // log.info(cookies);
        if (cookieName == null || cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
             //   // log.info("cookie.getName()--->"+cookie.getName());
              //  // log.info("cookie.getValue()--->"+cookie.getValue());
                return cookie.getValue();
            }
        }
        return null;
    }
}