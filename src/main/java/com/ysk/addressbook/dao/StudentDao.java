package com.ysk.addressbook.dao;

import com.ysk.addressbook.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    Student getStudentBySID(@Param("sid") String SID);



    void updateStudent(Student student);

    void deleteStudentBySID(@Param("sid") String SID);

    void addStudent(Student student);

    List<Student> findAllStudent();
}
