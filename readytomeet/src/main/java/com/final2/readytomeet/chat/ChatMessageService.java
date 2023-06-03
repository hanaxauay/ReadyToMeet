// ChatService.java
package com.final2.readytomeet.chat;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {
    private final ChatMessageDao chatMessageDao;

    public ChatMessageService(ChatMessageDao chatMessageDao) {
        this.chatMessageDao = chatMessageDao;
    }

    public void saveChatMessage(ChatMessageDto chatMessage) {
        chatMessageDao.insertChatMessage(chatMessage);
    }

    public List<ChatMessageDto> getAllChatMessages() {
        return chatMessageDao.getAllChatMessages();
    }
}
