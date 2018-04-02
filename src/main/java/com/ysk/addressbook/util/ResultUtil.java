package com.ysk.addressbook.util;

import com.ysk.addressbook.dto.Result;

public class ResultUtil {
    public static Result success(Object object){
        Result result=new Result();
        result.setMsg("成功");
        result.setData(object);
        result.setCode(0);
        return result;
    }
    public static Result success(){
        return success(null);
    }
    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setMsg(msg);
        result.setCode(code);
        return result;
    }
}
