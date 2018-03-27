package com.ysk.addressbook.service.Impl;

import com.ysk.addressbook.dao.ClassesDao;
import com.ysk.addressbook.entity.Classes;
import com.ysk.addressbook.entity.Student;
import com.ysk.addressbook.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesDao classesDao;

    @Override
    public List<Classes> findAllClasses() {
        return classesDao.findAllClasses();
    }

    @Override
    public void addOneClasses(Classes classes) {
        classesDao.addOneClasses(classes);
    }

    @Override
    public void updateOneClasses(Classes classes) {
        classesDao.updateOneClasses(classes);
    }

    @Override
    public void deleteOneClasses(String classesNum) {
        classesDao.deleteOneClasses(classesNum);
    }

    @Override
    public Classes getOneClasses(String classesNum) {
        return classesDao.getOneClasses(classesNum);
    }

    @Override
    public List<Student> getClassesByClassesNum(String classesNum) {
        return classesDao.getClassesByClassesNum(classesNum);
    }
}
