package com.ysk.addressbook.service.Impl;

import com.ysk.addressbook.dao.UserDao;
import com.ysk.addressbook.entity.User;
import com.ysk.addressbook.service.UserService;
import com.ysk.addressbook.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public  boolean checkUser(String username,String password){
        User user=userDao.getUserByUserName(username);
        password= ToolUtil.getMD5(password);
        System.out.println(password);
        if(user!=null&&password.equals(user.getPassword())){
            return  true;
        }else {
            return  false;
        }
    }
}
