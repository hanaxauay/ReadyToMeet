package com.final2.readytomeet.chat.mapper;

import com.final2.readytomeet.chat.dto.UserChatRoom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserChatRoomMapper {
    @Insert("INSERT INTO USER_CHAT_ROOM (USER_ID, ROOM_ID) VALUES (#{user_id}, #{room_id})")
    void addUserToChatRoom(UserChatRoom userChatRoom);

    @Select("SELECT USER_ID FROM USER_CHAT_ROOM WHERE ROOM_ID = #{room_id}")
    List<String> getUsersInChatRoom(Long roomId);
}


