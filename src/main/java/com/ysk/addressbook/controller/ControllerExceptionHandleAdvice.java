package com.ysk.addressbook.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class ControllerExceptionHandleAdvice {
//
//    @ExceptionHandler
//    public ResultEntity handler(HttpServletResponse res, Exception e) {
//        logger.info("Restful Http请求发生异常...");
//        if (res.getStatus() == HttpStatus.BAD_REQUEST.value()) {
//            res.setStatus(HttpStatus.OK.value());
//        }
//        if (e instanceof NullPointerException) {
//            return ResultEntity.NULL_POINT;
//        } else if (e instanceof IllegalArgumentException) {
//            return ResultEntity.PARAM_ERR;
//        } else if (e instanceof SQLException) {
//            return ResultEntity.SQL_EXC;
//        } else {
//            return ResultEntity.SERVER_EXC;
//        }
//    }
}
