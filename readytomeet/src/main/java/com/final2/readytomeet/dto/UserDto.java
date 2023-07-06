package com.final2.readytomeet.dto;


import lombok.*;


@Getter
@Setter
@NoArgsConstructor  // 기본 생성자 생성
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자 생성
public class UserDto {
    private String user_id;
    private String user_pw;
    private String user_phone;
    private String user_email;
    private String user_name;
    private String user_nickname;
    private Integer user_age;
    private Integer user_gender;
    private String user_location;
    private String user_img;
    private String user_path;
    private String user_content;

}
