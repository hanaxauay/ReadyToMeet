package com.final2.readytomeet.chat.controller;

import com.final2.readytomeet.chat.dto.ChatMessage;
import com.final2.readytomeet.chat.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;

@RequiredArgsConstructor
@Controller
public class ChatController {
    private final SimpMessageSendingOperations messagingTemplate;
    private final ChatMessageRepository chatMessageRepository;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
            message.setMessage(message.getUser_nickname() + "님이 입장하셨습니다.");
        } else {
            // 저장하는 로직 추가
            message.setTimestamp(new Timestamp(System.currentTimeMillis()));
            chatMessageRepository.saveChatMessage(message);
        }

        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getAppo_seq(), message);
    }
}
