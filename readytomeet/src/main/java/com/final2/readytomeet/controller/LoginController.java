package com.final2.readytomeet.controller;

import com.final2.readytomeet.Mapper.UserMapper;
import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserMapper userMapper;
    private final UserService userService;
    private final HttpSession session;
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // login.html (로그인 폼 템플릿)을 반환
    }

    @PostMapping("/login")
    public String login(@RequestParam("user_id") String user_id, @RequestParam("user_pw") String user_pw, Model model) {
        UserDto user = userMapper.selectOne(user_id);

        if (user != null && user.getUser_pw().equals(user_pw)) {
            model.addAttribute("loginUser", user);
            session.setAttribute("loggedInUser", user);
            return "redirect:/main"; // main.html (로그인 성공 페이지)을 반환
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login"; // 로그인 실패 시 에러 메시지와 함께 다시 로그인 폼 템플릿을 반환
        }
    }

    @GetMapping("/logout")
    public String logout() {
        session.removeAttribute("loggedInUser");
        session.invalidate();
        return "login"; // 로그인 폼 페이지로 리다이렉트
    }
}
