package com.final2.readytomeet.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDateTime;

@RestController
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageDao chatMessageDao;

    public ChatController(SimpMessagingTemplate messagingTemplate, ChatMessageDao chatMessageDao) {
        this.messagingTemplate = messagingTemplate;
        this.chatMessageDao = chatMessageDao;
    }

    @MessageMapping("/sendMessage")
    public void sendMessage(ChatMessageDto chatMessageDto, Principal principal) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(principal.getName());
        chatMessage.setMessage(chatMessageDto.getMessage());
        chatMessage.setTimestamp(LocalDateTime.now());

        chatMessageDao.save(chatMessage);

        messagingTemplate.convertAndSend("/topic/public", chatMessageDto);
    }
}
