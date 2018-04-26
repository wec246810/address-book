package com.ysk.addressbook.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.ysk.addressbook.config.RedisKey;
import com.ysk.addressbook.dto.Email;
import com.ysk.addressbook.service.SendEmailService;
import com.ysk.addressbook.util.JsonBuilder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: Y.S.K
 * Date:2018/4/22
 */
@RestController
@Log4j2
public class EmailController {

    private static final String emailPattern="\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";

    @Autowired
    private RedisTemplate<String,String> stringRedis;
    @Autowired
    private SendEmailService sendEmailService;
    @PostMapping("get-code")
    public JSON getCode(@RequestParam("username") String username, @RequestParam("toEmail") String toEmail){
        if(Strings.isNullOrEmpty(username)||Strings.isNullOrEmpty(toEmail)){
            return JsonBuilder.builder().put("errMsg","请求参数不正确").put("errCode",-1).build();
        }
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(toEmail);
        System.out.println(matcher.matches());
        if(!matcher.matches()){
            return JsonBuilder.builder().put("errMsg","邮箱格式不正确!").put("errCode",-1).build();
        }
        int code = (int) (Math.random()*10000+10000);
        stringRedis.opsForValue().set(RedisKey.USER_CODE_PREFIX +username,String.valueOf(code),5,TimeUnit.MINUTES);
        Email email=Email.builder().to(toEmail).subject("【Y.S.K】 账户验证服务").text("你好，你的验证码是"+code+"，5分钟之后将会失效。千万不要告诉别人哦，哈哈哈哈。").build();
        sendEmailService.send(email);
        return JsonBuilder.builder().put("errMsg","发送成功，请注意查收邮箱!").put("errCode",1).build();
    }
}
