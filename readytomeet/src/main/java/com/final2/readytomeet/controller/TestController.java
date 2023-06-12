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

  // 회원 정보 수정 페이지 이동
  @GetMapping("/user/update")
  public String gotouserUpdate() {
    return "userUpdate";
  }

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

  @GetMapping("/review")
  public String gotoReview(){
    return "review";
  }













}
