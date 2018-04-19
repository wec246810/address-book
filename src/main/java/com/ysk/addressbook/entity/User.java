package com.ysk.addressbook.entity;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {
     private String username;
     private String password;
     private int isAdmin;
     private String phone;
     private String email;

}
