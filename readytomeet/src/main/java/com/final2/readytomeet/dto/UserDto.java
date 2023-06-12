package com.final2.readytomeet.dto;

public class UserDto {
    private String user_id;
    private String user_pw;
    private String user_phone;
    private String uesr_email;
    private String user_nickname;
    private Integer user_age;
    private String user_location;
    private String user_content;

    public UserDto() {
        super();
    }

    public UserDto(String user_id, String user_pw, String user_phone,
                   String uesr_email, String user_nickname, Integer user_age,
                   String user_location, String user_content) {
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.user_phone = user_phone;
        this.uesr_email = uesr_email;
        this.user_nickname = user_nickname;
        this.user_age = user_age;
        this.user_location = user_location;
        this.user_content = user_content;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUesr_email() {
        return uesr_email;
    }

    public void setUesr_email(String uesr_email) {
        this.uesr_email = uesr_email;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public Integer getUser_age() {
        return user_age;
    }

    public void setUser_age(Integer user_age) {
        this.user_age = user_age;
    }

    public String getUser_location() {
        return user_location;
    }

    public void setUser_location(String user_location) {
        this.user_location = user_location;
    }

    public String getUser_content() {
        return user_content;
    }

    public void setUser_content(String user_content) {
        this.user_content = user_content;
    }
}
