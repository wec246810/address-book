package com.ysk.addressbook.service;

import com.google.common.base.Strings;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 描述
 * Created by Y.S.K on 2018/4/17 16:42
 */
@Service
@Log4j2
public class TokenService {
    @Autowired
    private RedisTemplate<String,String> stringRedis;
    public String checkLogin(String token) {
        String redisValue = stringRedis.opsForValue().get(token);
        if (Strings.isNullOrEmpty(redisValue)){
            return null;
        }else {
            return redisValue;
        }
    }
}
