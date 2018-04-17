package com.ysk.addressbook.service;

import com.ysk.addressbook.dto.StudentPosition;
import com.ysk.addressbook.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface  StudentService {
    Student getStudentBySID(@Param("SID") String SID);

    void updateStudent(Student student);

    void deleteStudentBySID( String SID);

    void addStudent(Student student);

    List<Student> findAllStudent();

    StudentPosition getStudentPosition(Student student);
}
