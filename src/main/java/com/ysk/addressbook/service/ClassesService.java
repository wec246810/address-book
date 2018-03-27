package com.ysk.addressbook.service;

import com.ysk.addressbook.entity.Classes;
import com.ysk.addressbook.entity.Student;

import java.util.List;

public interface ClassesService {
    List<Classes> findAllClasses();

    void addOneClasses(Classes classes);

    void updateOneClasses(Classes classes);

    void deleteOneClasses(String classesNum);

    Classes getOneClasses(String classesNum);

    List<Student> getClassesByClassesNum(String classesNum);

}
