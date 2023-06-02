package com.final2.readytomeet.chat;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageDao {

    @Insert("INSERT INTO chat_message (username, message, timestamp) VALUES (#{username}, #{message}, #{timestamp})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(ChatMessage chatMessage);

    @Select("SELECT * FROM chat_message")
    List<ChatMessage> findAll();

    // 추가적인 쿼리 메서드나 조작 로직 작성
}
