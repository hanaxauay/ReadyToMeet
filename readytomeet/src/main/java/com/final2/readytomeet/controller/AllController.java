package com.final2.readytomeet.controller;

import com.final2.readytomeet.Mapper.CommunityMapper;
import com.final2.readytomeet.dto.CommunityDto;
import com.final2.readytomeet.service.AppoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AllController {
  @Autowired
  private AppoService apposervice;

  @Autowired
  private CommunityMapper map;

  @GetMapping("/all")
  public String selectActivityAll(Model model) {
    model.addAttribute("activityList", apposervice.selectActivityAllList().subList(0, 2)); // 첫 번째 5개의 활동만 전달합니다.
    model.addAttribute("workList", apposervice.selectWorkAllList().subList(0, 2)); // 첫 번째 5개의 활동만 전달합니다.
    model.addAttribute("vehicleList", apposervice.selectVehicleAllList().subList(0, 2)); // 첫 번째 5개의 활동만 전달합니다.
    return "all";
  }
}
