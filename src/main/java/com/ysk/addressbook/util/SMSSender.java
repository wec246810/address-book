package com.ysk.addressbook.util;

import com.ysk.addressbook.config.SMSConfig;
import com.ysk.addressbook.util.http.HttpUtils;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 描述
 * Created by Y.S.K on 2018/4/21 11:02
 */
public class SMSSender {
    private static final String SMS_URL = "https://yun.tim.qq.com/v5/tlssmssvr/sendsms?sdkappid=xxxxx&random=xxxx";

    public static void send(String mobile, List<String> params) {
        String random = String.valueOf(new Random().nextInt(Integer.MAX_VALUE) + 100000);
        String time = Timestamp.from(Instant.now()).toString();

        String sign = getSign(mobile, SMSConfig.appkey, time, random);
        Map mobileMap = new HashMap();
        mobileMap.put("nationcode", "86");
        mobileMap.put("mobile", mobile);

        HttpUtils.post("https://yun.tim.qq.com/v5/tlssmssvr/sendsms?sdkappid=" + SMSConfig.appid
                + "&random=" + random, JsonBuilder.builder()
                .put("ext", "")
                .put("extend", "")
                .put("params", params)
                .put("sig", sign)
                .put("tel", mobileMap)
                .put("time", time)
                .put("tpl_id", 1)
                .build()
                .toString());
    }


    private static String getSign(String mobile, String appKey, String time, String random) {
        return SHA256Util.getSHA256Str("appkey=" + appKey + "&random=" + random + "&time=" + time + "&mobile=" + mobile);
    }
}
