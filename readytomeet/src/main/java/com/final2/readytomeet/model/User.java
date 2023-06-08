package com.final2.readytomeet.model;

import lombok.Data;


@Data
public class User {
    private Long user_id;
    private String user_pw;
    private String user_phone;
    private String user_email;
    private String user_name;
    private String user_nickname;
    private Integer user_age;
    private String user_gender;
    private String user_location;
    private String user_img;
    private String user_path;
    private String user_content;

}
