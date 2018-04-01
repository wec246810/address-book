package com.ysk.addressbook.controller;

import com.ysk.addressbook.dto.StudentPosition;
import com.ysk.addressbook.entity.Classes;
import com.ysk.addressbook.entity.Student;
import com.ysk.addressbook.service.ClassesService;
import com.ysk.addressbook.service.NoticeService;
import com.ysk.addressbook.service.StudentService;
import com.ysk.addressbook.service.UserService;
import com.ysk.addressbook.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
public class MyController {

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
    public ModelAndView classesDetail(@RequestParam("classesNum") String classesNum){
        List<Student> students=classesService.getClassesByClassesNum(classesNum);
        Classes classes=classesService.getOneClasses(classesNum);
        System.out.println(classes.getMonitorID());
        Student monitor=studentService.getStudentBySID(classes.getMonitorID());
        ModelAndView classesDetailMV=new ModelAndView("classes-detail");
        System.out.println(monitor);
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
