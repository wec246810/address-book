package com.ysk.addressbook.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.ysk.addressbook.annotation.CheckLogin;
import com.ysk.addressbook.entity.Classes;
import com.ysk.addressbook.entity.Student;
import com.ysk.addressbook.service.ClassesService;
import com.ysk.addressbook.service.NoticeService;
import com.ysk.addressbook.service.StudentService;
import com.ysk.addressbook.util.HttpUtils;
import com.ysk.addressbook.util.JsonBuilder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("admin")
@Log4j2
public class AdminController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassesService classesService;

    @Autowired
    private HttpUtils httpUtils;

    @Autowired
    private NoticeService noticeService;

    @GetMapping("index")
    @CheckLogin
    public ModelAndView adminIndex(){
        return new ModelAndView("admin-index");
    }

    /**
     * 公告更新
     * @param content
     * @return
     */
    @PostMapping("setNotice")
    public JSON  setNotice(@RequestParam("content") String content){
        if(Strings.isNullOrEmpty(content)){
            return JsonBuilder.builder().put("errmsg","公告更新失败").put("errCode",-1).build();
        }
        noticeService.update(content);
        return JsonBuilder.builder().put("errmsg","公告更新成功").put("errCode",1).build();
    }

    /**
     *学生管理页面
     * @param classesNum
     * @return
     */
    @GetMapping("classes-student-manage")
    @CheckLogin
    public ModelAndView adminDetail(@RequestParam("classesNum") String classesNum) {
        //获取本班所有学生
        classesNum = classesNum.trim();
        List<Student> students = classesService.getClassesByClassesNum(classesNum);
        ModelAndView studentDetailMV = new ModelAndView("classes-student-manage");
        studentDetailMV.addObject("students", students);
        studentDetailMV.addObject("classesNum", classesNum);
        return studentDetailMV;
    }

    /**
     * 添加学生
     * @param student
     * @return
     * @throws Exception
     */
    @PostMapping("add-student")
    @CheckLogin
    @ResponseBody
    public JSON addStudent(@RequestBody Student student) throws Exception {
        if (studentService.getStudentBySID(student.getSid()) != null) {
            return JsonBuilder.builder().put("errmsg","该学生信息已存在").put("errorCode",-1).build();
        }
        //下载并存储头像
        //采用异步的方式
        httpUtils.saveHeaderImg(student);
        //设置头像
        student.setHeaderURI("/img/" + student.getSid() + ".png");
        System.out.println(student.getHeaderURI());
        studentService.addStudent(student);
        return JsonBuilder.builder().put("errmsg","添加学生信息完成").put("errorCode",1).build();
    }


    /**
     * 删除学生
     * @param student
     * @return
     */
    @DeleteMapping("delete-student")
    @CheckLogin
    @ResponseBody
    public JSON deleteStudent(@RequestBody Student student) {
        //通过sid删除学生信息
        studentService.deleteStudentBySID(student.getSid());
        return JsonBuilder.builder().put("errmsg","删除学生信息完成").put("errorCode",1).build();
    }

    /**
     *更新学生信息
     * @param student
     * @return
     */
    @PutMapping("update-student")
    @CheckLogin
    @ResponseBody
    public JSON updateStudent(@RequestBody Student student) {
        //更新学生信息
        Student s = studentService.getStudentBySID(student.getSid());
        if(s==null){
            return JsonBuilder.builder().put("errmsg","该学生不存在").put("errorCode",-1).build();
        }
        s.setName(student.getName());
        s.setSex(student.getSex());
        studentService.updateStudent(s);
        return JsonBuilder.builder().put("errmsg","更新学生信息成功").put("errorCode",1).build();
    }



    /**
     * 班级管理页面
     *
     * @return
     */
    @GetMapping("classes-manage")
    @CheckLogin
    public ModelAndView getAllClasses() {
        List<Classes> classes = classesService.findAllClasses();
        ModelAndView classesMV = new ModelAndView("classes-manage");
        classesMV.addObject("classess", classes);
        return classesMV;
    }

    /**
     * 添加班级
     *
     * @param classes
     * @return
     */
    @PostMapping("classes")
    @CheckLogin
    @ResponseBody
    public JSON addClasses(@RequestBody Classes classes) {
        System.out.println(classes);
        try {
            classesService.addOneClasses(classes);
            return JsonBuilder.builder().put("errmsg","添加班级成功").put("errorCode",1).build();
        } catch (Exception ex) {
            System.out.println("添加班级信息出错");
            ex.printStackTrace();
            return JsonBuilder.builder().put("errmsg","添加班级出错").put("errorCode",-1).build();
        }
    }

    /**
     * 更新班级信息
     *
     * @param classes
     * @return
     */
    @PutMapping("classes")
    @CheckLogin
    @ResponseBody
    public JSON editClasses(@RequestBody Classes classes) {
        try {
            classesService.updateOneClasses(classes);
            return JsonBuilder.builder().put("errmsg","班级信息保存成功").put("errorCode",1).build();
        } catch (Exception ex) {
            log.info("更新班级信息出错");
            return JsonBuilder.builder().put("errmsg","班级信息保存失败").put("errorCode",-1).build();
        }
    }

    /**
     * 删除班级信息
     *
     * @param classes
     * @return
     */

    @CheckLogin
    @DeleteMapping("classes")
    @ResponseBody
    public JSON deleteClasses(@RequestBody Classes classes) {
        System.out.println(classes.getClassesNum());
        try {
            classesService.deleteOneClasses(classes.getClassesNum());
            return JsonBuilder.builder().put("errmsg","删除班级完成").put("errorCode",1).build();
        } catch (Exception ex) {
            System.out.println("删除班级信息出错");
            return JsonBuilder.builder().put("errmsg","删除班级出错").put("errorCode",-1).build();
        }
    }
}
