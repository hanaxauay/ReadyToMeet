package com.final2.readytomeet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test {
  @GetMapping("/all")
  public String test1(){
    return "all";
  }
  @GetMapping("/community")
  public String test2() {
      return "community";
  }

  @GetMapping("/activity")
  public String test3(){
    return "activityBaseListPage";
  }

}
