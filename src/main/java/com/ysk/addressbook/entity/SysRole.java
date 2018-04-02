package com.ysk.addressbook.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SysRole {
    private Integer id;
    private String name;
    private String roleLevel;
    private String description;


}
