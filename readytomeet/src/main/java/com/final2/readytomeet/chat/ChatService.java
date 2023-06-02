package com.final2.readytomeet.chat;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private final ChatMessageDao chatMessageDao;

    public ChatService(ChatMessageDao chatMessageDao) {
        this.chatMessageDao = chatMessageDao;
    }

    public void saveChatMessage(ChatMessage chatMessage) {
        chatMessageDao.save(chatMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessageDao.findAll();
    }

    // 기타 필요한 비즈니스 로직들을 추가할 수 있습니다.
}
