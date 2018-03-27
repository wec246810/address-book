package com.ysk.addressbook.handle;

import com.ysk.addressbook.enums.ResultEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    public ResultEntity handleException(Exception e) {
        e.printStackTrace();
        return ResultEntity.FAILED;
    }
}
