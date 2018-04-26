package com.ysk.addressbook.controller;

import com.ysk.addressbook.entity.Student;
import com.ysk.addressbook.service.StudentService;
import com.ysk.addressbook.util.HttpUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述
 * Created by Y.S.K on 2018/4/2 11:49
 */
@Controller
@Log4j2
public class TestController {
    @Autowired
    private StudentService studentService;
    @GetMapping("insert")
    @ResponseBody
    public String insert() {
        Student student = new Student();
        HttpUtils httpUtils = new HttpUtils();
        for (int i = 1; i < 45; i++) {
            for (int j = 1401; j < 1420; j++) {
                if(i<10){
                    student.setSid((1462 + "") + (j + "") + ("0" + i));
                }else {
                    student.setSid((1462 + "") + (j + "") + ("" + i));
                }
                student.setName("姓名" + j + i);
                student.setSex("男");
                student.setClassesNum(j + "");
                log.info(student);
                studentService.addStudent(student);
            }
        }
        return "插入完成";
    }
}
