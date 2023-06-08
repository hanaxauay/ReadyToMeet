package com.final2.readytomeet.chat.mapper;

import com.final2.readytomeet.chat.dto.ChatRoom;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChatRoomMapper {

    @Select("SELECT * FROM CHAT_ROOM")
    List<ChatRoom> findAllRoom();

    @Select("SELECT * FROM CHAT_ROOM WHERE ROOM_ID = #{room_id}")
    ChatRoom findRoomById(String id);

    @Insert("INSERT INTO CHAT_ROOM (room_id, room_name) VALUES (#{room_id}, #{room_name})")
    void createChatRoom(ChatRoom chatRoom);
}
