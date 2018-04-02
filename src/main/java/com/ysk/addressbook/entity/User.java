package com.ysk.addressbook.entity;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {
     private String username;
     private String password;

     private List<SysRole> roleList;//一个用户拥有多个角色


}
