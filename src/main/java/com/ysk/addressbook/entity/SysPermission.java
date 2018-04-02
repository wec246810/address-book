package com.ysk.addressbook.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SysPermission {
    private Integer id;
    private String name;
    private String permissionUrl;
    private String method;
    private String description;

}
