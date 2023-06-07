package com.final2.readytomeet.dto;

import java.util.Date;

public class CommunityDto {

  private Integer share_seq;
  private String share_category;
  private String share_title;
  private String share_content;
  private Date share_time;
  private String user_id;
  private String filename;
  private String filepath;

  public CommunityDto(Integer share_seq, String share_category, String share_title, String share_content, Date share_time, String user_id, String filename, String filepath) {
    this.share_seq = share_seq;
    this.share_category = share_category;
    this.share_title = share_title;
    this.share_content = share_content;
    this.share_time = share_time;
    this.user_id = user_id;
    this.filename = filename;
    this.filepath = filepath;
  }

  public Integer getShare_seq() {
    return share_seq;
  }

  public void setShare_seq(Integer share_seq) {
    this.share_seq = share_seq;
  }

  public String getShare_category() {
    return share_category;
  }

  public void setShare_category(String share_category) {
    this.share_category = share_category;
  }

  public String getShare_title() {
    return share_title;
  }

  public void setShare_title(String share_title) {
    this.share_title = share_title;
  }

  public String getShare_content() {
    return share_content;
  }

  public void setShare_content(String share_content) {
    this.share_content = share_content;
  }

  public Date getShare_time() {
    return share_time;
  }

  public void setShare_time(Date share_time) {
    this.share_time = share_time;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getFilepath() {
    return filepath;
  }

  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }
}