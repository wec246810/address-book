package com.ysk.addressbook.entity;

import lombok.*;

import java.time.LocalTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MessageBoard {
    private String content;
    private User receiver;
    private LocalTime createTime;
    private User sender;


}
