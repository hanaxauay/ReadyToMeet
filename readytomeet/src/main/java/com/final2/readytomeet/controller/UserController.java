package com.final2.readytomeet.controller;

import com.final2.readytomeet.Mapper.UserMapper;
import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;
    private final HttpSession session;




    @GetMapping("/View")
    public String selectOne(Model model, String user_id) {
        model.addAttribute("dto", userService.selectOne(user_id));
        return "userView";
    }

    @PostMapping("/Update")
    public String update(UserDto dto, Model model) {
        model.addAttribute("message", "회원 정보 수정 완료");
        model.addAttribute("searchUrl", "/user/View");

            return "redirect:/user/Update?user_id=" + dto.getUser_id();
    }
    @GetMapping("/update")
    public String gotouserUpdate() {
        return "userUpdate";
    }

}
