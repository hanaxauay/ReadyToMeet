package com.final2.readytomeet.chat;

import com.final2.readytomeet.chat.dto.ChatMessage;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ChatMessageRepository {
    private List<ChatMessage> chatMessages;

    @PostConstruct
    private void init() {
        chatMessages = new ArrayList<>();
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void addChatMessage(ChatMessage chatMessage) {
        chatMessages.add(chatMessage);
    }
}
