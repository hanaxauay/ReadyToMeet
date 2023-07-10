package com.final2.readytomeet.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class JoinDto {
    private Long id;
    private String USER_ID;
    private String USER_PW;
    private String USER_PHONE;
    private String USER_EMAIL;
    private String USER_NAME;
    private String USER_NICKNAME;
    private int USER_AGE;
    private int USER_GENDER;
    private String USER_LOCATION;
}