package com.ysk.addressbook.controller;

import com.google.common.base.Strings;
import com.ysk.addressbook.dto.StudentPosition;
import com.ysk.addressbook.entity.Classes;
import com.ysk.addressbook.entity.Student;
import com.ysk.addressbook.service.ClassesService;
import com.ysk.addressbook.service.NoticeService;
import com.ysk.addressbook.service.StudentService;
import com.ysk.addressbook.service.UserService;
import com.ysk.addressbook.util.HttpUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@Log4j2
public class MyController {
    @Autowired
    private RedisTemplate<String,String> redis;

    @Autowired
    private UserService userService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private ClassesService classesService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("check-user")
    public String checkUser(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse response) {
        if (userService.checkUser(username, password)) {
            //登陆成功,生成token，对应学号，存入redis中
            String token=UUID.randomUUID().toString();
            stringRedisTemplate.opsForValue().set(token,username,24*7, TimeUnit.HOURS);
            HttpUtils.addCookie(response,"token",token,7*24*3600);
            return "redirect:/index";
        } else {
            return "redirect:/login";
        }
    }

 //登陆页面
    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("index")
    public ModelAndView index() {
        String notice=noticeService.getMyNotice();
        List<Classes> classess= classesService.findAllClasses();
        ModelAndView indexMV=new ModelAndView("index");
        indexMV.addObject("notice",notice);
        indexMV.addObject("classess",classess);
        return indexMV;
    }

    //班级详情页面
    @GetMapping("classes-detail")
    public ModelAndView classesDetail(@RequestParam("classesNum") String classesNum, HttpServletRequest request){
        List<Student> students=classesService.getClassesByClassesNum(classesNum);
        Classes classes=classesService.getOneClasses(classesNum);
        System.out.println(classes.getMonitorId());
        Student monitor=studentService.getStudentBySID(classes.getMonitorId());
        ModelAndView classesDetailMV=new ModelAndView("classes-detail");
        String imonitor=redis.opsForValue().get(HttpUtils.getCookieByName(request,"token").getValue());
        log.info("从Redis中取出的imonitor--->"+imonitor);

        if(imonitor.equals(classes.getMonitorId())){
            System.out.println("是班长");
            classesDetailMV.addObject("imonitor","1");
        }else {
            System.out.println("不是班长");
            classesDetailMV.addObject("imonitor","0");
        }
        classesDetailMV.addObject("monitor",monitor);
        classesDetailMV.addObject("students",students);
        classesDetailMV.addObject("classesNum",classesNum);
        return classesDetailMV;
    }


    //学生详情页面
    @GetMapping("student-detail")
    public ModelAndView studentDetail(@RequestParam("SID") String SID){
        Student student=studentService.getStudentBySID(SID);
       StudentPosition studentPosition= studentService.getStudentPosition(student);
        ModelAndView studentDetailMV=new ModelAndView("student-detail");
        studentDetailMV.addObject("studentPosition",studentPosition);
        studentDetailMV.addObject("student",student);
        return studentDetailMV;
    }








}
