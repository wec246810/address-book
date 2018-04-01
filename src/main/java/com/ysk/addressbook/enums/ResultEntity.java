package com.ysk.addressbook.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResultEntity {
    SUCCESS(0, "成功"),
    FAILED(10001, "失败"),
    NULL_POINT(10002, "空指针异常"),
    PARAM_ERR(10003, "请求参数异常"),
    SQL_EXC(10004, "数据库异常"),
    SERVER_EXC(10005,"服务器异常"),;

    ResultEntity(Integer errCode, String msg) {
        this.errCode = errCode;
        this.msg = msg;
    }

    private Integer errCode;
    private String msg;

    public Integer getErrCode() {
        return errCode;
    }

    public String getMsg() {
        return msg;
    }
}
