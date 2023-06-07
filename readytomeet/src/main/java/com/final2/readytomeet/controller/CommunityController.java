package com.final2.readytomeet.controller;

import com.final2.readytomeet.dto.CommunityDto;
import com.final2.readytomeet.mapper.CommunityMapper;
import com.final2.readytomeet.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CommunityController {

  @Autowired
  private CommunityMapper map;

  @Autowired
  private CommunityService service;

  @PostMapping("/community/writepro")
  public String write(CommunityDto dto, Model model, @RequestParam(name = "file", required = false) MultipartFile file){
    try {
      if (file != null && !file.isEmpty()) {
        service.write(dto, file);
      } else {
        service.write(dto, null);
      }
      model.addAttribute("message", "글 작성이 완료되었습니다.");
      model.addAttribute("searchUrl", "/community");
      return "message";
    } catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("message", "글 작성 중 오류가 발생했습니다.");
      model.addAttribute("searchUrl", "/community");
      return "message";
    }
  }














}
