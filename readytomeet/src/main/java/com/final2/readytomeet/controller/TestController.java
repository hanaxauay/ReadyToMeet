package com.final2.readytomeet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
  @GetMapping("/all")
  public String gotoAll(){
    return "all";
  }

  @GetMapping("/activity")
  public String gotoActivity(){
    return "activityBaseListPage";
  }

  @GetMapping("/vehicle")
  public String gotoVehicle(){
    return "vehicleBaseListPage";
  }

  @GetMapping("/work")
  public String gotoWork(){
    return "workBaseListPage";
  }

  @GetMapping("/main")
  public String gotoMain(){
    return "main";
  }

//  @GetMapping("/chat")
//  public String gotoChat(){
//    return "chat";
//  }


  @GetMapping("/mypage")
  public String gotomypage() { return "mypage"; }

  @GetMapping("/login")
  public String gotoLogin(){
    return "login";
  }

  @GetMapping("/joinForm")
  public String gotoJoinForm(){
    return "joinForm";
  }













}
