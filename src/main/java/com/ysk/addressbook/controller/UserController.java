package com.ysk.addressbook.controller;

import com.google.common.base.Strings;
import com.ysk.addressbook.config.RedisKey;
import com.ysk.addressbook.entity.User;
import com.ysk.addressbook.service.StudentService;
import com.ysk.addressbook.service.UserService;
import com.ysk.addressbook.util.CookieUtil;
import com.ysk.addressbook.util.MD5Util;
import com.ysk.addressbook.util.SMSSender;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 用于用户修改个人资料
 */
@Controller
@Log4j2
public class UserController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Map<String, String>> redisTemplate;
    @Autowired
    private RedisTemplate<String,String> stringRedis;

    /**
     * 检查用户名和密码
     *
     * @param username
     * @param password
     * @param response
     * @return
     */
    @PostMapping("check-user")
    @ResponseBody
    public String checkUser(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse response) throws IOException {
        User user = userService.getUserByUserName(username);
        if (Strings.isNullOrEmpty(username) || Strings.isNullOrEmpty(password)) {
            return "用户名或密码格式不正确";
        }
        if (user == null) {
//            temp.addObject("errmsg", "该用户不存在");
//            temp.setViewName("error");
            return "该用户不存在";
        }
        if (user.getPassword().equals(MD5Util.getMD5(password))) {
            String token = UUID.randomUUID().toString();
            Map<String, String> userMap = new HashMap<>();
            userMap.put(RedisKey.USER_NAME, username);
            userMap.put(RedisKey.IS_ADMIN, String.valueOf(user.getIsAdmin()));
            redisTemplate.opsForValue().set(token, userMap, 24 * 7, TimeUnit.HOURS);
            CookieUtil.addCookie(response, "token", token, 7 * 24 * 3600);
            response.sendRedirect("index");
            return null;
        }
//        temp.addObject("errmsg", "用户名或密码错误");
//        temp.setViewName("error");
        return "用户名或密码错误";
    }


    /**
     * 注册用户请求
     *
     * @param username
     * @param password
     * @return TODO: 加上短信验证
     */
    @PostMapping("register-user")
    @ResponseBody
    public String registerUser(@RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("code")String code, HttpServletResponse response, @RequestParam("password1") String password1) throws IOException {
        if (Strings.isNullOrEmpty(username) || Strings.isNullOrEmpty(password) || Strings.isNullOrEmpty(password1)||Strings.isNullOrEmpty(code)) {
//            return JsonBuilder.builder().put("errormsg", "用户名或者密码不能为空").put("errorCode", -1).build();
            return "请将所有需要填的内容补全";
        }
        if (!password.equals(password1)) {
            return "两次输入密码不一致";
        }
        String redisCode=stringRedis.opsForValue().get(RedisKey.USER_CODE_PREFIX+username);
        if(Strings.isNullOrEmpty(redisCode)||!code.equals(redisCode)){
            return "验证码不正确";
        }
        User user = userService.getUserByUserName(username);
        if (user != null) {
//            return JsonBuilder.builder().put("errormsg", "该用户名已经存在").put("errorCode", -1).build();
            return "该用户名已经存在";
        }
        userService.addUser(User.builder().username(username.trim()).password(MD5Util.getMD5(password.trim())).build());
        response.sendRedirect("login");
//        return JsonBuilder.builder().put("errormsg", "注册成功").put("errorCode", 1).build();
        return "注册成功";
    }

    /**
     * 注册页面
     *
     * @return
     */
    @GetMapping("register")
    public String register() {
        return "register";
    }

    /**
     * 登录页面
     *
     * @return
     */
    @GetMapping("login")
    public String login() {
        return "login";
    }


    @GetMapping("test")
    public void test(@RequestParam("mobile") String mobile) {
        List<String> list = new ArrayList<>();
        list.add("2321");
        SMSSender.send(mobile, list);
    }

}
