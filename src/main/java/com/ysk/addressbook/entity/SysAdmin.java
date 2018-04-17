package com.ysk.addressbook.entity;

import lombok.*;

/**
 * 描述
 * Created by Y.S.K on 2018/4/17 20:01
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SysAdmin {
    private int id;
    private String username;
    private String password;
}
