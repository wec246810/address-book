package com.ysk.addressbook.dao;

import com.ysk.addressbook.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
        User getUserByUserName(@Param("username") String username);

        void updateUser(User user);

        void deteleUserById(String userId);

        void addUser(User user);

        List<User> findAllUser();

}
