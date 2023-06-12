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

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper map;

    @Autowired
    private UserService biz;

    @GetMapping("/View")
    public String selectOne(Model model, String user_id) {
        model.addAttribute("dto", biz.selectOne(user_id));
        return "userView";
    }

    @PostMapping("/Update")
    public String update(UserDto dto, Model model) {
        model.addAttribute("message", "회원 정보 수정 완료");
        model.addAttribute("searchUrl", "/user/View");
        if(biz.update(dto)>0){
            return "message";
        } else {
            return "redirect:/user/Update?user_id=" + dto.getUser_id();
        }
    }


}
