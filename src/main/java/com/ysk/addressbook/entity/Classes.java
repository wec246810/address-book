package com.ysk.addressbook.entity;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Classes {
    private int classesId;
    private String classesNum;
    private String classesName;
    private  String headerURI;
//    private  String classesURI;
    private  String monitorId;
    private String admin;
}
