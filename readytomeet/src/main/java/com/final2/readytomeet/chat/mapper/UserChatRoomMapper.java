package com.final2.readytomeet.chat.mapper;

import com.final2.readytomeet.chat.dto.ChatRoom;
import com.final2.readytomeet.chat.dto.UserChatRoom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserChatRoomMapper {
    @Insert("INSERT INTO USER_CHAT_ROOM (USER_NICKNAME, ROOM_ID) VALUES (#{user_nickname}, #{room_id})")
    void addUserToChatRoom(UserChatRoom userChatRoom);

    @Select("SELECT USER_NICKNAME FROM USER_CHAT_ROOM WHERE ROOM_ID = #{room_id}")
    List<String> getUsersInChatRoom(Long roomId);

    @Select("SELECT r.* FROM CHAT_ROOM r INNER JOIN USER_CHAT_ROOM ucr ON r.ROOM_ID = ucr.ROOM_ID WHERE ucr.USER_NICKNAME = #{nickname}")
    List<ChatRoom> getChatRoomsByUserNickname(String nickname);


    @Insert("INSERT INTO USER_CHAT_ROOM (USER_NICKNAME, ROOM_ID) VALUES (#{user_nickname}, #{room_id})")
    void insertUserChatRoom(@Param("user_nickname") String user_nickname, @Param("room_id") String room_id);

    @Select("SELECT COUNT(*) FROM USER_CHAT_ROOM WHERE USER_NICKNAME = #{nickname} AND ROOM_ID = #{room_id}")
    int isUserJoined(@Param("nickname") String nickname, @Param("room_id") String room_id);
}
