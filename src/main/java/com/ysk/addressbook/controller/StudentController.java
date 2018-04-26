package com.ysk.addressbook.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.ysk.addressbook.annotation.CheckLogin;
import com.ysk.addressbook.config.RedisKey;
import com.ysk.addressbook.dto.StudentPosition;
import com.ysk.addressbook.entity.Student;
import com.ysk.addressbook.service.StudentService;
import com.ysk.addressbook.util.HttpUtils;
import com.ysk.addressbook.util.JsonBuilder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Log4j2
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private RedisTemplate<String,Map<String,Integer>> hashIntegerRedis;
    /**
     * 更新学生信息
     * @param student
     * @return
     */
    @PostMapping("update-info")
    @CheckLogin
    @ResponseBody
    public JSON updateMyInfo(@RequestBody Student student) {
        Student student1=studentService.getStudentBySID(student.getSid());
        if(student1==null){
            return JsonBuilder.builder().put("errmsg","该学生不存在！").put("errCode",1).build();
        }
        studentService.updateStudent(student1);
        return JsonBuilder.builder().put("errmsg","信息更新成功").put("errCode",1).build();
    }

    /**
     * 学生详情页面
     * @param SID
     * @return
     */
    @GetMapping("student-detail")
    @CheckLogin
    public String studentDetail(@RequestParam("SID") String SID, Model model, HttpServletRequest request){
        if(Strings.isNullOrEmpty(SID)){
            model.addAttribute("errmsg","请求参数有误");
            return "error";
        }
        Student student=studentService.getStudentBySID(SID);
        if(student==null){
            model.addAttribute("errmsg","该学生不存在");
            return "error";
        }
        //判断是不是本人
       String userSid= String.valueOf(hashIntegerRedis.opsForValue().get(HttpUtils.getCookieByName(request,"token").getValue()).get(RedisKey.USER_NAME));
        if(SID.equals(userSid)){
            model.addAttribute("isSelf","1");
        }
        StudentPosition studentPosition= studentService.getStudentPosition(student);

        model.addAttribute("studentPosition",studentPosition);
        model.addAttribute("student",student);
        return "student-detail";
    }
}
