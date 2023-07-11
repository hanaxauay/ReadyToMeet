package com.final2.readytomeet.controller;


import com.final2.readytomeet.dto.AppoDto;
import com.final2.readytomeet.dto.UserInfoDto;
import com.final2.readytomeet.service.UserInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/userinfo")
public class UserInfoController {
  @Autowired
  private UserInfoService userinforservice;

  //-------------------Activity userinfo -----------------------
  //참여 검색
  @GetMapping("/selectUserInfoActivity")
  public String selectUserInfolListActivity(Model model, int appo_seq){
    model.addAttribute("userInfoDto", userinforservice.selectUserInfolList(appo_seq));
    return "redirect:/appointment/detailActivityPage?appo_seq="+appo_seq;
  }
  //약속 참여
  @GetMapping("/insertUserInfoActivity")
  public String insertUserInfoActivity(UserInfoDto userinfodto) {
    if(userinforservice.insertUserInfo(userinfodto) > 0){
      //성공 시 해당 약속 상세페이지 이동
      return "redirect:/appointment/detailActivityPage?appo_seq="+userinfodto.appo_seq;
    }else {
      //실패 시 처리 작업 필요하면 추가
      return "redirect:/appointment/detailActivityPage?appo_seq="+userinfodto.appo_seq;
    }
  }
  //약속 취소
  @GetMapping("/deleteUserInfoIdActivity")
  public String deleteUserInfoIdActivity(String user_id, int appo_seq){
    //삭제 시 필요한 메세지 추가
    userinforservice.deleteUserInfoId(user_id);
    return "redirect:/appointment/detailActivityPage?appo_seq="+appo_seq;
  }


  //-------------------Vehicle userinfo -----------------------
  //참여 검색
  @GetMapping("/selectUserInfoVehicle")
  public String selectUserInfolListVehicle(Model model, int appo_seq){
    model.addAttribute("userInfoDto", userinforservice.selectUserInfolList(appo_seq));
    return "redirect:/appointment/detailVehicle?appo_seq="+appo_seq;
  }
  //약속 참여
  @GetMapping("/insertUserInfoVehicle")
  public String insertUserInfoVehicle(UserInfoDto userinfodto) {
    if(userinforservice.insertUserInfo(userinfodto) > 0){
      //성공 시 해당 약속 상세페이지 이동
      return "redirect:/appointment/detailVehicle?appo_seq="+userinfodto.appo_seq;
    }else {
      //실패 시 처리 작업 필요하면 추가
      return "redirect:/appointment/detailVehicle?appo_seq="+userinfodto.appo_seq;
    }
  }
  //약속 취소
  @GetMapping("/deleteUserInfoIdVehicle")
  public String deleteUserInfoIdVehicle(String user_id, int appo_seq){
    //삭제 시 필요한 메세지 추가
    userinforservice.deleteUserInfoId(user_id);
    return "redirect:/appointment/detailVehicle?appo_seq="+appo_seq;
  }

  //-------------------Work userinfo -----------------------
  //참여 검색
  @GetMapping("/selectUserInfoWork")
  public String selectUserInfolListWork(Model model, int appo_seq){
    model.addAttribute("userInfoDto", userinforservice.selectUserInfolList(appo_seq));
    return "redirect:/appointment/detailWork?appo_seq="+appo_seq;
  }
  //약속 참여
  @GetMapping("/insertUserInfoWork")
  public String insertUserInfoWork(UserInfoDto userinfodto) {
    if(userinforservice.insertUserInfo(userinfodto) > 0){
      //성공 시 해당 약속 상세페이지 이동
      return "redirect:/appointment/detailWork?appo_seq="+userinfodto.appo_seq;
    }else {
      //실패 시 처리 작업 필요하면 추가
      return "redirect:/appointment/detailWork?appo_seq="+userinfodto.appo_seq;
    }
  }
  //약속 취소
  @GetMapping("/deleteUserInfoIdWork")
  public String deleteUserInfoIdWork(String user_id, int appo_seq){
    //삭제 시 필요한 메세지 추가
    userinforservice.deleteUserInfoId(user_id);
    return "redirect:/appointment/detailWork?appo_seq="+appo_seq;
  }
}
