package com.ysk.addressbook.dto;

public class Result<T> {
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    //错误码
    private  Integer code;
    //提示信息
    private String msg;
    //具体内容
    private T data;


    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }
}
