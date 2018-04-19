package com.ysk.addressbook.service;


import com.ysk.addressbook.entity.User;

public interface UserService {
    boolean checkUser(String username,String password);
    void addUser(User user);
    User getUserByUserName(String username);
}
