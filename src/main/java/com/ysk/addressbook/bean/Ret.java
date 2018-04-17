package com.ysk.addressbook.bean;

import com.ysk.addressbook.config.RetCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * 描述
 * Created by Y.S.K on 2018/4/17 16:47
 */
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST)
@Getter
@Setter
@Component
public class Ret {

    private int err;
    private String desc;

    public Ret() {
        this.err = RetCode.OK;
    }

}
