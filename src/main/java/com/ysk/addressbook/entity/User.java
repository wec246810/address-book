package com.ysk.addressbook.entity;

import java.util.List;

public class User {
     private String username;
     private String password;

     private List<SysRole> roleList;//一个用户拥有多个角色


     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public List<SysRole> getRoleList() {
          return roleList;
     }

     public void setRoleList(List<SysRole> roleList) {
          this.roleList = roleList;
     }

}
