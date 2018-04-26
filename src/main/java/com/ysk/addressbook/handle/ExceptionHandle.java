package com.ysk.addressbook.handle;

import com.alibaba.fastjson.JSON;
import com.ysk.addressbook.util.JsonBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    public JSON handleException(Exception e) {
        e.printStackTrace();
        return JsonBuilder.builder().put("errMsg","出现异常").put("errCode",-1).build();
    }
}
