package com.final2.readytomeet.dto;


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

    public UserDto() { super();}

     public UserDto(String user_id, String user_pw, String user_phone, String user_email, String user_name, String user_nickname, Integer user_age, Integer user_gender, String user_location, String user_img, String user_path, String user_content) {
         this.user_id = user_id;
         this.user_pw = user_pw;
         this.user_phone = user_phone;
         this.user_email = user_email;
         this.user_name = user_name;
         this.user_nickname = user_nickname;
         this.user_age = user_age;
         this.user_gender = user_gender;
         this.user_location = user_location;
         this.user_img = user_img;
         this.user_path = user_path;
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

     public String getUser_email() {
         return user_email;
     }

     public void setUser_email(String user_email) {
         this.user_email = user_email;
     }

     public String getUser_name() {
         return user_name;
     }

     public void setUser_name(String user_name) {
         this.user_name = user_name;
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

     public Integer getUser_gender() {
         return user_gender;
     }

     public void setUser_gender(Integer user_gender) {
         this.user_gender = user_gender;
     }

     public String getUser_location() {
         return user_location;
     }

     public void setUser_location(String user_location) {
         this.user_location = user_location;
     }

     public String getUser_img() {
         return user_img;
     }

     public void setUser_img(String user_img) {
         this.user_img = user_img;
     }

     public String getUser_path() {
         return user_path;
     }

     public void setUser_path(String user_path) {
         this.user_path = user_path;
     }

     public String getUser_content() {
         return user_content;
     }

     public void setUser_content(String user_content) {
         this.user_content = user_content;
     }

    @Override
    public String toString() {
        return "UserDto{" +
                "user_id='" + user_id + '\'' +
                ", user_pw='" + user_pw + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_nickname='" + user_nickname + '\'' +
                ", user_age=" + user_age +
                ", user_gender=" + user_gender +
                ", user_location='" + user_location + '\'' +
                ", user_content='" + user_content + '\'' +
                '}';
    }
}
