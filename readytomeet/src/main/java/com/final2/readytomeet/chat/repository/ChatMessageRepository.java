package com.final2.readytomeet.chat.repository;

import com.final2.readytomeet.chat.dto.ChatMessage;
import org.springframework.stereotype.Repository;

import com.final2.readytomeet.chat.mapper.ChatMessageMapper;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ChatMessageRepository {
    private final ChatMessageMapper chatMessageMapper;

    public void saveChatMessage(ChatMessage chatMessage) {
        chatMessageMapper.saveChatMessage(chatMessage);
    }
}

