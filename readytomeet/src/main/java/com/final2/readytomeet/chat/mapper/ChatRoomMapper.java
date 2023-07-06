package com.final2.readytomeet.chat.mapper;

import com.final2.readytomeet.chat.dto.ChatRoom;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChatRoomMapper {

    @Select("SELECT * FROM CHAT_ROOM")
    List<ChatRoom> findAllRoom();

    @Select("SELECT * FROM CHAT_ROOM WHERE APPO_SEQ = #{appo_seq}")
    ChatRoom getChatRoomById(int appo_seq);

    @Select("SELECT * FROM CHAT_ROOM WHERE USER_NICKNAME = #{user_nickname}")
    List<ChatRoom> findRoomByNickname(String nickname);

    @Insert("INSERT INTO CHAT_ROOM (APPO_SEQ, room_name) VALUES (#{appo_seq}, #{room_name})")
    void createChatRoom(ChatRoom chatRoom);
}
