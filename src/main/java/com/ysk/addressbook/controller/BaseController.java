package com.ysk.addressbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/403")
    public String is403(){
        System.out.println("------没有权限-------");
        return "403";
    }

    @GetMapping("/404")
    public String is404(){
        System.out.println("------页面不存在-------");
        return "404";
    }

}
