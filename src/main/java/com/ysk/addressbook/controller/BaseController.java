package com.ysk.addressbook.controller;

import com.google.common.base.Strings;
import com.ysk.addressbook.annotation.CheckLogin;
import com.ysk.addressbook.config.Config;
import com.ysk.addressbook.config.RedisKey;
import com.ysk.addressbook.entity.Classes;
import com.ysk.addressbook.service.ClassesService;
import com.ysk.addressbook.service.NoticeService;
import com.ysk.addressbook.service.UserService;
import com.ysk.addressbook.util.CookieUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
public class BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private ClassesService classesService;

    @Autowired
    private RedisTemplate<String,Map<String,String>> hashStringRedis;

    /**
     * 403页面
     * @return
     */
    @GetMapping("/403")
    public String is403(){
        System.out.println("------没有权限-------");
        return "403";
    }

    /**
     * 404页面
     * @return
     */
    @GetMapping("/404")
    public String is404(){
        System.out.println("------页面不存在-------");
        return "404";
    }

    /**
     * 首页
     * @param request
     * @return
     */
    @GetMapping("index")
    @CheckLogin
    public ModelAndView index(HttpServletRequest request) {
        String notice=noticeService.getMyNotice();
        List<Classes> classess= classesService.findAllClasses();
        if(Strings.isNullOrEmpty(notice)||classess.size()==0||classess==null){
            log.info("主页信息获取异常-->"+notice+" " +classess);
        }
        ModelAndView indexMV=new ModelAndView("index");

       Map<String,String> userMap = hashStringRedis.opsForValue().get(CookieUtil.getCookie(request, Config.TOKEN));
        if(userMap==null){
            log.info("用户未登陆或登陆已失效");
        }
        indexMV.addObject("classess",classess);
        indexMV.addObject("notice",notice);
        indexMV.addObject("admin",userMap.get(RedisKey.IS_ADMIN));
        return indexMV;
    }
}
