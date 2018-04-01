package com.ysk.addressbook.controller;

import com.ysk.addressbook.entity.Student;
import com.ysk.addressbook.enums.ResultEntity;
import com.ysk.addressbook.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用于用户修改个人资料
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private StudentService studentService;

    @GetMapping("login")
    public void userLogin() {

    }

    @PostMapping("update-info")
    @ResponseBody
    public ResultEntity updateMyInfo(@RequestBody Student student) {
        studentService.updateStudent(student);
        return ResultEntity.SUCCESS;
    }

    @GetMapping("user-detail")
    public ModelAndView studentDetail(@RequestParam("SID") String SID) {
        Student student = studentService.getStudentBySID(SID);
        ModelAndView studentDetailMV = new ModelAndView("user-detail");
        studentDetailMV.addObject("student", student);
        return studentDetailMV;
    }


}
