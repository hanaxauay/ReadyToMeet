package com.final2.readytomeet.controller;

import com.final2.readytomeet.dto.JoinDto;
import com.final2.readytomeet.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoinController {
    private final JoinService joinService;

    @Autowired
    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @PostMapping("/join")
    public String joinUser(
            @RequestParam("USER_ID") String userId,
            @RequestParam("USER_PW") String userPw,
            @RequestParam("USER_PHONE") String userPhone,
            @RequestParam("USER_EMAIL") String userEmail,
            @RequestParam("USER_NAME") String userName,
            @RequestParam("USER_NICKNAME") String userNickname,
            @RequestParam("USER_AGE") int userAge,
            @RequestParam("USER_GENDER") int userGender,
            @RequestParam("USER_LOCATION") String userLocation) {

        JoinDto joinDto = new JoinDto();
        joinDto.setUSER_ID(userId);
        joinDto.setUSER_PW(userPw);
        joinDto.setUSER_PHONE(userPhone);
        joinDto.setUSER_EMAIL(userEmail);
        joinDto.setUSER_NAME(userName);
        joinDto.setUSER_NICKNAME(userNickname);
        joinDto.setUSER_AGE(userAge);
        joinDto.setUSER_GENDER(userGender);
        joinDto.setUSER_LOCATION(userLocation);

        joinService.addUser(joinDto);
        return "login"; // or return a success view
    }
}

