package com.ysk.addressbook.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResultEntity {
      SUCCESS(0,"成功"),
      FAILED(1,"失败"),
    ;
    ResultEntity(Integer errCode,String msg){
        this.errCode=errCode;
        this.msg=msg;
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
