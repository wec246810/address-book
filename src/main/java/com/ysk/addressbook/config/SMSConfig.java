package com.ysk.addressbook.config;

/**
 * 描述
 * Created by Y.S.K on 2018/4/21 10:56
 */
public class SMSConfig {
    // 短信应用SDK AppID
//   public final int appid = 1400009099; // 1400开头
    public static final int appid = 1400086229;
    // 短信应用SDK AppKey
//    public final String appkey = "9ff91d87c2cd7cd0ea762f141975d1df37481d48700d70ac37470aefc60f9bad";

    public static final String appkey = "0984206d87fcbc47847d1ce38ce8c302";

    // 短信模板ID，需要在短信应用中申请
    public static final int templateId = 1; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请

    // 签名
    public static final String smsSign = "Y.S.K"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需
}
