package com.ysk.addressbook.dto;

import lombok.*;

/**
 * Author: Y.S.K
 * Date:2018/4/22
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Email {

    private String to;
    private String subject;
    private String text;
}
