package com.ysk.addressbook.controller;

import com.ysk.addressbook.entity.Student;
import com.ysk.addressbook.enums.ResultEntity;
import com.ysk.addressbook.service.ClassesService;
import com.ysk.addressbook.service.StudentService;
import com.ysk.addressbook.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassesService classesService;

    @Autowired
    private HttpUtils httpUtils;

//    所有进行trim处理

    @GetMapping("admin-detail")
    public  ModelAndView adminDetail(@RequestParam("classesNum") String classesNum){
        //获取本班所有学生
        List<Student> students=classesService.getClassesByClassesNum(classesNum);
        ModelAndView studentDetailMV=new ModelAndView("admin-detail");
        studentDetailMV.addObject("students",students);
        studentDetailMV.addObject("classesNum",classesNum);
        return studentDetailMV;
    }

    @PostMapping("add-student")
    @ResponseBody
    public ResultEntity addStudent(@RequestBody Student student) throws Exception {
        if(studentService.getStudentBySID(student.getSid())!=null){
            return ResultEntity.FAILED;
        }
        //下载并存储头像
                                                       //采用异步的方式
        httpUtils.saveHeaderImg(student);
        //设置头像
        student.setHeaderURI("/img/"+student.getSid()+".png");
        System.out.println(student.getHeaderURI());
        studentService.addStudent(student);
      return ResultEntity.SUCCESS ;
    }

    @DeleteMapping("delete-student")
    @ResponseBody
    public ResultEntity deleteStudent(@RequestBody Student student){
        //通过sid删除学生信息
        studentService.deleteStudentBySID(student.getSid());
        return ResultEntity.SUCCESS ;
    }

    @PutMapping("update-student")
    @ResponseBody
    public ResultEntity updateStudent(@RequestBody Student student){
        //更新学生信息
        Student s = studentService.getStudentBySID(student.getSid());
        s.setName(student.getName());
        s.setSex(student.getSex());
        studentService.updateStudent(s);
        return ResultEntity.SUCCESS ;
    }

}
