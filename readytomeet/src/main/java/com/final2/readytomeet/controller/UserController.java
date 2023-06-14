package com.final2.readytomeet.controller;

import com.final2.readytomeet.Mapper.UserMapper;

import com.final2.readytomeet.dto.UserDto;

import com.final2.readytomeet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/user")
public class UserController {



    @Autowired
    private UserMapper map;

    @Autowired
    private UserService service;

    @GetMapping("/View")
    public String selectOne(Model model, String user_img) {
        model.addAttribute("dto", service.selectOne(user_img));
        return "userView";
    }

    @PostMapping("/Update")
    public String update(UserDto dto, Model model) {
        model.addAttribute("message", "회원 정보 수정 완료");
        model.addAttribute("searchUrl", "/user/View");

            return "redirect:/user/Update?user_id=" + dto.getUser_id();
    }


    @PostMapping("/upload")
    public String upload(UserDto dto, Model model, @RequestParam(name = "file", required = false) MultipartFile file){
        try {
            if (file != null && !file.isEmpty()) {
                service.upload(dto, file);
            } else {
                service.upload(dto, null);
            }
            model.addAttribute("message", "글 작성이 완료되었습니다.");
            model.addAttribute("searchUrl", "/user/View");
            return "message";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "글 작성 중 오류가 발생했습니다.");
            model.addAttribute("searchUrl", "/user/View");
            return "message";
        }
    }
    @GetMapping("/update")
    public String gotouserUpdate() {
        return "userUpdate";
    }

}
