package com.ysk.addressbook.controller;

import com.alibaba.fastjson.JSON;
import com.ysk.addressbook.annotation.CheckLogin;
import com.ysk.addressbook.dto.StudentPosition;
import com.ysk.addressbook.entity.Student;
import com.ysk.addressbook.service.StudentService;
import com.ysk.addressbook.util.JsonBuilder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j2
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    /**
     * 更新学生信息
     * @param student
     * @return
     */
    @PostMapping("update-info")
    @CheckLogin
    @ResponseBody
    public JSON updateMyInfo(@RequestBody Student student) {
        studentService.updateStudent(student);
        return JsonBuilder.builder().put("errmsg","信息更新成功").put("errCode",1).build();
    }

    /**
     * 学生详情页面
     * @param SID
     * @return
     */
    @GetMapping("student-detail")
    @CheckLogin
    public ModelAndView studentDetail(@RequestParam("SID") String SID){
        Student student=studentService.getStudentBySID(SID);
        ModelAndView studentDetailMV=new ModelAndView("student-detail");
        if(student==null){
            studentDetailMV =new ModelAndView("error");
            studentDetailMV.addObject("errmsg","该学生不存在");
            return studentDetailMV;
        }
        StudentPosition studentPosition= studentService.getStudentPosition(student);

        studentDetailMV.addObject("studentPosition",studentPosition);
        studentDetailMV.addObject("student",student);
        return studentDetailMV;
    }
}
