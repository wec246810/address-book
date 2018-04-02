package com.ysk.addressbook.controller;

import com.ysk.addressbook.enums.ResultEntity;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@RestControllerAdvice
@Log4j2
public class ControllerExceptionHandleAdvice {
    private final static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandleAdvice.class);
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
