package com.ysk.addressbook.controller;

import com.ysk.addressbook.annotation.CheckLogin;
import com.ysk.addressbook.entity.Classes;
import com.ysk.addressbook.entity.Student;
import com.ysk.addressbook.enums.ResultEntity;
import com.ysk.addressbook.service.ClassesService;
import com.ysk.addressbook.service.StudentService;
import com.ysk.addressbook.util.HttpUtils;
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

    //所有进行trim处理
    @GetMapping("admin-detail")
    @CheckLogin
    public ModelAndView adminDetail(@RequestParam("classesNum") String classesNum) {
        //获取本班所有学生
        classesNum = classesNum.trim();
        List<Student> students = classesService.getClassesByClassesNum(classesNum);
        ModelAndView studentDetailMV = new ModelAndView("admin-detail");
        studentDetailMV.addObject("students", students);
        studentDetailMV.addObject("classesNum", classesNum);
        return studentDetailMV;
    }

    @PostMapping("add-student")
    @CheckLogin
    @ResponseBody
    public ResultEntity addStudent(@RequestBody Student student) throws Exception {
        if (studentService.getStudentBySID(student.getSid()) != null) {
            return ResultEntity.FAILED;
        }
        //下载并存储头像
        //采用异步的方式
        httpUtils.saveHeaderImg(student);
        //设置头像
        student.setHeaderURI("/img/" + student.getSid() + ".png");
        System.out.println(student.getHeaderURI());
        studentService.addStudent(student);
        return ResultEntity.SUCCESS;
    }

    @DeleteMapping("delete-student")
    @CheckLogin
    @ResponseBody
    public ResultEntity deleteStudent(@RequestBody Student student) {
        //通过sid删除学生信息
        studentService.deleteStudentBySID(student.getSid());
        return ResultEntity.SUCCESS;
    }

    @PutMapping("update-student")
    @CheckLogin
    @ResponseBody
    public ResultEntity updateStudent(@RequestBody Student student) {
        //更新学生信息
        Student s = studentService.getStudentBySID(student.getSid());
        s.setName(student.getName());
        s.setSex(student.getSex());
        studentService.updateStudent(s);
        return ResultEntity.SUCCESS;
    }

    /**
     * 添加班级
     * @param classes
     * @return
     */
    @PostMapping("classes")
    @CheckLogin
    @ResponseBody
    public ResultEntity addClasses(@RequestBody Classes classes){
        System.out.println(classes);
        try {
            classesService.addOneClasses(classes);
            return ResultEntity.SUCCESS;
        }catch (Exception ex){
            System.out.println("添加班级信息出错");
            ex.printStackTrace();
             return ResultEntity.FAILED;
        }
    }

    /**
     * 获取所有班级
     * @return
     */
    @GetMapping("classes")
    @CheckLogin
    public ModelAndView getAllClasses(){
      List<Classes> classes =  classesService.findAllClasses();
        ModelAndView classesMV = new ModelAndView("classes");
        classesMV.addObject("classess", classes);
        return classesMV;
    }

    /**
     * 更新班级信息
     * @param classes
     * @return
     */
    @PutMapping("classes")
    @CheckLogin
    @ResponseBody
    public ResultEntity editClasses(@RequestBody Classes classes){
        try {
            classesService.updateOneClasses(classes);
            return ResultEntity.SUCCESS;
        }catch (Exception ex){
            log.info("更新班级信息出错");
            return ResultEntity.FAILED;
        }
    }

    /**
     * 删除班级信息
     * @param classes
     * @return
     */
    @DeleteMapping("classes")
    @CheckLogin
    @ResponseBody
    public ResultEntity deleteClasses(@RequestBody Classes classes){
        System.out.println(classes.getClassesNum());
        try {
            classesService.deleteOneClasses(classes.getClassesNum());
            return ResultEntity.SUCCESS;
        }catch (Exception ex){
            System.out.println("删除班级信息出错");
            return ResultEntity.FAILED;
        }
    }
}
