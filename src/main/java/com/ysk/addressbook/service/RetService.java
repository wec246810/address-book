package com.ysk.addressbook.service;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.ysk.addressbook.bean.Ret;
import com.ysk.addressbook.config.RetCode;
import com.ysk.addressbook.util.JsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by lei on 24/08/2017.
 * Yes, you can.
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class RetService {

    private final ApplicationContext applicationContext;
    public static final JSON INVALID_ERR = generateRet(RetCode.INVALID_PARAM);
    public static final JSON NOT_LOGIN_ERR = generateRet(RetCode.NOT_LOGIN);
    public static final JSON IP_ILLEGAL_ERR = generateRet(RetCode.IP_ILLEGAL);

    public static JSON generateRet(int error) {
        return generateRet(error, RetCode.getMsg(error));
    }

    public static JSON generateRet(int error, String msg) {
        return JsonBuilder.builder().put("error", error)
                .put("msg", msg)
                .put("data", null)
                .build();
    }

    private Ret getRetInternal() {
        try {
            return applicationContext.getBean(Ret.class);
        } catch (Exception ex) {
            // log.error("This can only be invoked in Request Thread!");
            throw ex;
        }
    }

    public JSON getRet() {
        return getRet(null);
    }

    public JSON getRet(Object obj) {
        Ret ret = getRetInternal();
        String msg = ret.getDesc();
        return JsonBuilder.builder().put("error", ret.getErr())
                .put("msg", Strings.isNullOrEmpty(msg) ? RetCode.getMsg(ret.getErr()) : msg)
                .put("data", obj)
                .build();
    }

    public void setError(int code) {
        getRetInternal().setErr(code);
    }

    public void setError(int code, String msg) {
        Ret ret = getRetInternal();
        ret.setDesc(msg);
        ret.setErr(code);
    }

    public int getError() {
        return getRetInternal().getErr();
    }
}
