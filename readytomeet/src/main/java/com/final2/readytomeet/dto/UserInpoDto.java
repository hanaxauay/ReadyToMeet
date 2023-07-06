package com.final2.readytomeet.dto;

public class UserInpoDto {
    public String user_id;
    public int appo_seq;

    public UserInpoDto() {
    }

    public UserInpoDto(String user_id, int appo_seq) {
        this.user_id = user_id;
        this.appo_seq = appo_seq;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getAppo_seq() {
        return appo_seq;
    }

    public void setAppo_seq(int appo_seq) {
        this.appo_seq = appo_seq;
    }
}
