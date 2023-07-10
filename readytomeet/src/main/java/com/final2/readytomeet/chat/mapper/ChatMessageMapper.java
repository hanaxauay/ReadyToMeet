package com.final2.readytomeet.chat.mapper;

import com.final2.readytomeet.chat.dto.ChatMessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChatMessageMapper {
    @Insert("INSERT INTO CHAT_MESSAGE (APPO_SEQ, USER_NICKNAME, MESSAGE, TIMESTAMP) " +
            "VALUES (#{appo_seq}, #{user_nickname}, #{message}, #{timestamp})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    void saveChatMessage(ChatMessage chatMessage);

    @Select("SELECT * FROM CHAT_MESSAGE WHERE APPO_SEQ = #{appo_seq} ORDER BY TIMESTAMP")
    List<ChatMessage> getChatMessagesByRoomId(@Param("appo_seq") int appo_seq);


}
