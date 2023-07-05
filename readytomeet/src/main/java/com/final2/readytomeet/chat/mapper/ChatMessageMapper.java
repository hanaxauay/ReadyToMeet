package com.final2.readytomeet.chat.mapper;

import com.final2.readytomeet.chat.dto.ChatMessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChatMessageMapper {
    @Insert("INSERT INTO CHAT_MESSAGE (ROOM_ID, USER_NICKNAME, MESSAGE, TIMESTAMP) " +
            "VALUES (#{room_id}, #{user_nickname}, #{message}, #{timestamp})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    void saveChatMessage(ChatMessage chatMessage);

    @Select("SELECT * FROM CHAT_MESSAGE WHERE ROOM_ID = #{room_id} ORDER BY TIMESTAMP")
    List<ChatMessage> getChatMessagesByRoomId(@Param("room_id") String room_id);


}
