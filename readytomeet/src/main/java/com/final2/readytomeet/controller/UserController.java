package com.final2.readytomeet.controller;

import com.final2.readytomeet.Mapper.CommunityMapper;
import com.final2.readytomeet.Mapper.UserMapper;

import com.final2.readytomeet.dto.CommunityDto;
import com.final2.readytomeet.dto.Pagination;
import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.net.MalformedURLException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper map;

    @Autowired
    private UserService service;


    @GetMapping("/View")
    public String selectOne(Model model, String user_id) {
        model.addAttribute("dto", service.selectOne(user_id));
        return "userView";
    }

    @PostMapping("/upload")
    public String upload(UserDto dto, Model model, @RequestParam(name = "file", required = false) MultipartFile file){
        try {
            if (file != null && !file.isEmpty()) {
                service.upload(dto, file);
            } else {
                service.upload(dto, null);
            }
            model.addAttribute("message", "사진 업로드 완료되었습니다.");
            model.addAttribute("searchUrl", "/user/View");
            return "message";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "사진 업로드 중 오류가 발생했습니다.");
            model.addAttribute("searchUrl", "/user/View");
            return "message";
        }
    }


    @GetMapping("/updateform")
    public String updateform(Model model, String user_id) {
        model.addAttribute("dto", service.selectOne(user_id));
        return "userUpdate";
    }

    @PostMapping("/Update")
    public String update(UserDto dto, Model model) {
        model.addAttribute("message", "회원 정보 수정 완료");
        model.addAttribute("searchUrl", "/user/View");
        if(service.update(dto) > 0) {
            return "message";
        }else{
            return "redirect:/user/updateform?user_id=" + dto.getUser_id();
        }

    }

    @GetMapping("Update")
    public String gotouserview(){
        return "userView";
    }

}
