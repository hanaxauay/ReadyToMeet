package com.final2.readytomeet.model;

import lombok.Data;

import javax.persistence.*;

@Entity //jpa 용
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String user_pw;
    private String user_phone;
    private String user_email;
    private String user_name;
    private Integer user_age;
    private String user_gender;
    private String user_location;
    private String user_image;
    private String user_path;
    private String user_content;
    private Integer user_appo_cnt;
    private Integer user_appo_like;

}
