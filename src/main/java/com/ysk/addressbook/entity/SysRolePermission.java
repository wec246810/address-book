package com.ysk.addressbook.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SysRolePermission {
    private String roleId;
    private String permissionId;

}
