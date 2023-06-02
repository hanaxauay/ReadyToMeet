package com.final2.readytomeet.chat;

import com.final2.readytomeet.chat.ChatMessageDto;

import java.util.List;

public interface ChatMessageDao {
    void insertChatMessage(ChatMessageDto chatMessage);
    List<ChatMessageDto> getAllChatMessages();
}
