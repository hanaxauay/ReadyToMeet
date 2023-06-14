package com.final2.readytomeet.chat.controller;


import com.final2.readytomeet.chat.repository.ChatRoomRepository;
import com.final2.readytomeet.chat.dto.ChatRoom;
import com.final2.readytomeet.chat.repository.UserChatRoomRepository;
import com.final2.readytomeet.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomRepository chatRoomRepository;
    private final UserChatRoomRepository userChatRoomRepository;

    // 채팅 리스트 화면
    //@GetMapping("/room")
    //public String rooms(Model model) {
        //return "/chat/room";
    //}
    // 모든 채팅방 목록 반환
//    @GetMapping("/rooms")
//    @ResponseBody
//    public List<ChatRoom> room() {
//        return chatRoomRepository.findAllRoom();
//    }

    @GetMapping("/room")
    public String getUserChatRooms(Model model, HttpSession session) {
        // 세션에서 로그인한 사용자 정보 가져오기
        UserDto loginUser = (UserDto) session.getAttribute("loggedInUser");
        String nickname = loginUser.getUser_nickname();

        // 사용자의 채팅방 목록 조회
        List<ChatRoom> userChatRooms = userChatRoomRepository.getChatRoomsByUserNickname(nickname);

        // 채팅방 목록을 모델에 추가
        model.addAttribute("userChatRooms", userChatRooms);
        return "chat/room";
    }

    // 채팅방 생성
    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name) {
        return chatRoomRepository.createChatRoom(name);
    }
    // 채팅방 입장 화면
    @GetMapping("/room/enter/{room_id}")
    public String roomDetail(Model model, @PathVariable String room_id) {
        model.addAttribute("room_id", room_id);
        return "chat/roomdetail";
    }
    // 특정 채팅방 조회
    @GetMapping("/room/{room_id}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String room_id) {
        return chatRoomRepository.findRoomById(room_id);
    }
}
