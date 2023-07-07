package com.final2.readytomeet.chat.controller;


import com.final2.readytomeet.chat.dto.ChatMessage;
import com.final2.readytomeet.chat.mapper.ChatMessageMapper;
import com.final2.readytomeet.chat.mapper.UserChatRoomMapper;
import com.final2.readytomeet.chat.repository.ChatMessageRepository;
import com.final2.readytomeet.chat.repository.ChatRoomRepository;
import com.final2.readytomeet.chat.dto.ChatRoom;
import com.final2.readytomeet.chat.repository.UserChatRoomRepository;
import com.final2.readytomeet.dto.AppoDto;
import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.service.AppoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ChatRoomController {

    private final ChatRoomRepository chatRoomRepository;
    private final UserChatRoomRepository userChatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final UserChatRoomMapper userChatRoomMapper;
    private final ChatMessageMapper chatMessageMapper;
    private final AppoService appoService;

    // 채팅 리스트 화면
    @GetMapping("/chat/room")
    public String rooms(Model model, HttpSession session) {
        UserDto loginUser = (UserDto) session.getAttribute("loggedInUser");
        String nickname = loginUser.getUser_nickname();
        List<ChatRoom> userChatRooms = userChatRoomRepository.getChatRoomsByUserNickname(nickname);
        model.addAttribute("userChatRooms", userChatRooms);
        model.addAttribute("nickname", nickname);
        return "chat/room";
    }

    // 모든 채팅방 목록 반환
    // 채팅방 생성
    @PostMapping("/chat/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam int appo_seq, @RequestParam String name) {
        return chatRoomRepository.createChatRoom(appo_seq, name);
    }

    @GetMapping("/chat/rooms")
    @ResponseBody
    public List<ChatRoom> room(HttpSession session) {
        UserDto loginUser = (UserDto) session.getAttribute("loggedInUser");
        String nickname = loginUser.getUser_nickname();
        return userChatRoomRepository.getChatRoomsByUserNickname(nickname);
    }

    @GetMapping("/chat/roomsss")
    @ResponseBody
    public AppoDto roomsss(Model model, @RequestParam int appo_seq, HttpSession session) {
        UserDto loggedInUser = (UserDto) session.getAttribute("loggedInUser");
        return appoService.selectAppointmentOneList(appo_seq);
    }



    // 채팅방 입장 화면
    @GetMapping("/chat/room/{appo_seq}")
    public String roomDetail(Model model, @PathVariable int appo_seq, HttpSession session) {


        List<ChatMessage> chatRoom = chatMessageRepository.getChatMessagesByRoomId(appo_seq);
//        ChatRoom chatRoom = new ChatRoom();
//        chatRoom.setRoom_id(room_id);
        model.addAttribute("userChatRooms", chatRoom);

        ChatRoom chatRoom1 = chatRoomRepository.getChatRoomById(appo_seq);
        model.addAttribute("chatRoom1", chatRoom1);



        // 사용자를 채팅방에 추가
        UserDto loginUser = (UserDto) session.getAttribute("loggedInUser");
        String nickname = loginUser.getUser_nickname();
        // 이미 채팅방에 참여한 사용자인지 확인
        int isUserJoined = userChatRoomMapper.isUserJoined(nickname, appo_seq);
        if (isUserJoined ==0) {
            // 처음 참여하는 사용자일 경우에만 채팅방에 추가
            userChatRoomRepository.insertUserChatRoom(nickname, appo_seq);
        }
        // 로그인한 사용자의 닉네임도 모델에 추가
        model.addAttribute("loginUser", loginUser);
        return "chat/roomdetail";
    }

    @GetMapping("/chats/room/{appo_seq}")
    @ResponseBody
    public List<ChatMessage> getChats(@PathVariable int appo_seq) {
        return chatMessageRepository.getChatMessagesByRoomId(appo_seq);
    }



}



