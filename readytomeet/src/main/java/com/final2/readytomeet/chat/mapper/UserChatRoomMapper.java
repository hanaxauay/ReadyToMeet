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
    @Insert("INSERT INTO USER_CHAT_ROOM (USER_NICKNAME, APPO_SEQ) VALUES (#{user_nickname}, #{appo_seq})")
    void addUserToChatRoom(UserChatRoom userChatRoom);

    @Select("SELECT USER_NICKNAME FROM USER_CHAT_ROOM WHERE APPO_SEQ = #{appo_seq}")
    List<String> getUsersInChatRoom(Long roomId);

    @Select("SELECT r.* FROM CHAT_ROOM r INNER JOIN USER_CHAT_ROOM ucr ON r.APPO_SEQ = ucr.APPO_SEQ WHERE ucr.USER_NICKNAME = #{nickname}")
    List<ChatRoom> getChatRoomsByUserNickname(String nickname);


    @Insert("INSERT INTO USER_CHAT_ROOM (USER_NICKNAME, APPO_SEQ) VALUES (#{user_nickname}, #{appo_seq})")
    void insertUserChatRoom(@Param("user_nickname") String user_nickname, @Param("appo_seq") int appo_seq);

    @Select("SELECT COUNT(*) FROM USER_CHAT_ROOM WHERE USER_NICKNAME = #{nickname} AND APPO_SEQ = #{appo_seq}")
    int isUserJoined(@Param("nickname") String nickname, @Param("appo_seq") int appo_seq);
}
