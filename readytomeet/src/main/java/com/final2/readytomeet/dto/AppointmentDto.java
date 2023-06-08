package com.final2.readytomeet.dto;

import java.util.Date;

public class AppointmentDto {
    public int appo_seq;
    public String appo_title;
    public String appo_content;
    public String appo_notice;
    public String appo_host;
    public String appo_place;
    public Date appo_time;
    public int appo_min_mem;
    public int appo_max_mem;
    public String appo_category;
    public String appo_start_place;
    public int appo_pay;
    public int appo_using;

    public AppointmentDto() {
    }

    public AppointmentDto(int appo_seq, String appo_title, String appo_content, String appo_notice, String appo_host, String appo_place, Date appo_time, int appo_min_mem, int appo_max_mem, String appo_category, String appo_start_place, int appo_pay, int appo_using) {
        this.appo_seq = appo_seq;
        this.appo_title = appo_title;
        this.appo_content = appo_content;
        this.appo_notice = appo_notice;
        this.appo_host = appo_host;
        this.appo_place = appo_place;
        this.appo_time = appo_time;
        this.appo_min_mem = appo_min_mem;
        this.appo_max_mem = appo_max_mem;
        this.appo_category = appo_category;
        this.appo_start_place = appo_start_place;
        this.appo_pay = appo_pay;
        this.appo_using = appo_using;
    }

    public int getAppo_seq() {
        return appo_seq;
    }

    public void setAppo_seq(int appo_seq) {
        this.appo_seq = appo_seq;
    }

    public String getAppo_title() {
        return appo_title;
    }

    public void setAppo_title(String appo_title) {
        this.appo_title = appo_title;
    }

    public String getAppo_content() {
        return appo_content;
    }

    public void setAppo_content(String appo_content) {
        this.appo_content = appo_content;
    }

    public String getAppo_notice() {
        return appo_notice;
    }

    public void setAppo_notice(String appo_notice) {
        this.appo_notice = appo_notice;
    }

    public String getAppo_host() {
        return appo_host;
    }

    public void setAppo_host(String appo_host) {
        this.appo_host = appo_host;
    }

    public String getAppo_place() {
        return appo_place;
    }

    public void setAppo_place(String appo_place) {
        this.appo_place = appo_place;
    }

    public Date getAppo_time() {
        return appo_time;
    }

    public void setAppo_time(Date appo_time) {
        this.appo_time = appo_time;
    }

    public int getAppo_min_mem() {
        return appo_min_mem;
    }

    public void setAppo_min_mem(int appo_min_mem) {
        this.appo_min_mem = appo_min_mem;
    }

    public int getAppo_max_mem() {
        return appo_max_mem;
    }

    public void setAppo_max_mem(int appo_max_mem) {
        this.appo_max_mem = appo_max_mem;
    }

    public String getAppo_category() {
        return appo_category;
    }

    public void setAppo_category(String appo_category) {
        this.appo_category = appo_category;
    }

    public String getAppo_start_place() {
        return appo_start_place;
    }

    public void setAppo_start_place(String appo_start_place) {
        this.appo_start_place = appo_start_place;
    }

    public int getAppo_pay() {
        return appo_pay;
    }

    public void setAppo_pay(int appo_pay) {
        this.appo_pay = appo_pay;
    }

    public int getAppo_using() {
        return appo_using;
    }

    public void setAppo_using(int appo_using) {
        this.appo_using = appo_using;
    }
}
