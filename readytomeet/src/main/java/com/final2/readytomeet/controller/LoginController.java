package com.final2.readytomeet.controller;

import com.final2.readytomeet.Mapper.UserMapper;
import com.final2.readytomeet.chat.dto.ChatRoom;
import com.final2.readytomeet.chat.mapper.ChatRoomMapper;
import com.final2.readytomeet.chat.repository.ChatMessageRepository;
import com.final2.readytomeet.chat.repository.UserChatRoomRepository;
import com.final2.readytomeet.dto.JoinDto;
import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.service.JoinService;
import com.final2.readytomeet.service.UserService;
import com.final2.readytomeet.service.testService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserMapper userMapper;
    private final UserService userService;
    private final HttpSession session;
    private final UserChatRoomRepository userChatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomMapper chatRoomMapper;
    private final JoinService JoinService;
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // login.html (로그인 폼 템플릿)을 반환
    }

    @PostMapping("/login")
    public String login(@RequestParam("user_id") String user_id, @RequestParam("user_pw") String user_pw, Model model) {
        UserDto user = userMapper.readUser(user_id);

        if (user != null && user.getUser_pw().equals(user_pw)) {
            model.addAttribute("loginUser", user);
            session.setAttribute("loggedInUser", user);
            model.addAttribute("success", "로그인 성공");
            return "redirect:/main"; // main.html (로그인 성공 페이지)을 반환
        } else {
            model.addAttribute("error", "로그인에 실패하였습니다. 아이디와 비밀번호를 다시 확인해주세요.");
            return "login";
        }
    }

    @GetMapping("/")
    public String home() {
        UserDto loggedInUser = (UserDto) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            return "redirect:/main"; // 이미 로그인한 상태이므로 main.html로 리다이렉트
        } else {
            return "index"; // 로그인하지 않은 상태이므로 index.html을 반환
        }
    }

    @GetMapping("/logout")
    public String logout() {
        session.removeAttribute("loggedInUser");
        session.invalidate();
        return "login"; // 로그인 폼 페이지로 리다이렉트
    }

    @GetMapping("/find")
    public String showPwFindForm() {
        return "pwfind"; // pwfind.html (비밀번호 찾기 폼 템플릿)을 반환
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "joinForm"; // joinForm.html (회원 가입 폼 템플릿)을 반환
    }

    @GetMapping("/main")
    public String gotoMain(Model model){
        UserDto loginUser = (UserDto) session.getAttribute("loggedInUser");
        String nickname = loginUser.getUser_nickname();
        List<ChatRoom> userChatRooms = userChatRoomRepository.getChatRoomsByUserNickname(nickname);
        model.addAttribute("userChatRooms", userChatRooms);


//        ChatRoom chatRoomById = chatRoomMapper.getChatRoomById(room_id);
//
//        List<ChatMessage> chatRoom = chatMessageRepository.getChatMessagesByRoomId(room_id);

        if (loginUser != null) {
            return "main"; // 로그인 상태이므로 main.html 반환
        } else {
            return "redirect:/login"; // 로그인하지 않은 상태이므로 로그인 페이지로 리다이렉트
        }
    }

    @RequestMapping(value = "/phoneCheck", method = RequestMethod.GET)
    @ResponseBody
    public String sendSMS(@RequestParam("phone") String userPhoneNumber) { // 휴대폰 문자보내기
        int randomNumber = (int)((Math.random()* (9999 - 1000 + 1)) + 1000);//난수 생성

        testService.certifiedPhoneNumber(userPhoneNumber,randomNumber);

        return Integer.toString(randomNumber);
    }

        @PostMapping("/join")
        public String join(@ModelAttribute JoinDto joinDto){
            JoinService.join(joinDto);
            return "login";
        }

}
