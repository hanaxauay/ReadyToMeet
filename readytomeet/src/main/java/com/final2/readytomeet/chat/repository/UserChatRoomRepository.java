package com.final2.readytomeet.chat.repository;

import com.final2.readytomeet.chat.dto.ChatRoom;
import com.final2.readytomeet.chat.dto.UserChatRoom;
import org.springframework.stereotype.Repository;
import com.final2.readytomeet.chat.mapper.UserChatRoomMapper;


import java.util.List;

@Repository
public class UserChatRoomRepository {

    private final UserChatRoomMapper userChatRoomMapper;

    public UserChatRoomRepository(UserChatRoomMapper userChatRoomMapper) {
        this.userChatRoomMapper = userChatRoomMapper;
    }

    public void addUserToChatRoom(UserChatRoom userChatRoom) {
        userChatRoomMapper.addUserToChatRoom(userChatRoom);
    }

    public List<String> getUsersInChatRoom(Long roomId) {
        return userChatRoomMapper.getUsersInChatRoom(roomId);
    }

    public List<ChatRoom> getChatRoomsByUserNickname(String nickname) {
        return userChatRoomMapper.getChatRoomsByUserNickname(nickname);
    }

    public void insertUserChatRoom(String user_nickname, String room_id) {
        userChatRoomMapper.insertUserChatRoom(user_nickname, room_id);
    }


}
