package com.ysk.addressbook.controller;

import com.ysk.addressbook.annotation.CheckLogin;
import com.ysk.addressbook.entity.Classes;
import com.ysk.addressbook.entity.Student;
import com.ysk.addressbook.service.ClassesService;
import com.ysk.addressbook.service.StudentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 描述
 * Created by Y.S.K on 2018/4/17 21:53
 */
@Controller
@Log4j2
public class ClassesController {
    @Autowired
    private RedisTemplate<String, String> redis;

    @Autowired
    private ClassesService classesService;

    @Autowired
    private StudentService studentService;

    /**
     * 班级详情页面
     *
     * @param classesNum
     * @param request
     * @return
     */
    @GetMapping("classes-detail")
    @CheckLogin
    public ModelAndView classesDetail(@RequestParam("classesNum") String classesNum, HttpServletRequest request) {
        List<Student> students = classesService.getClassesByClassesNum(classesNum);
        Classes classes = classesService.getOneClasses(classesNum);
        if (students == null | students.size() == 0 || classes == null) {
            ModelAndView classesDetailMV = new ModelAndView("error");
            classesDetailMV.addObject("errmsg", "传入的班级信息有误");
            return classesDetailMV;
        }
        Student monitor = studentService.getStudentBySID(classes.getMonitorId());
        ModelAndView classesDetailMV = new ModelAndView("classes-detail");
        if (monitor != null) {
            classesDetailMV.addObject("monitor", monitor);
        }
        classesDetailMV.addObject("students", students);
        classesDetailMV.addObject("classesNum", classesNum);
        return classesDetailMV;
    }
}
