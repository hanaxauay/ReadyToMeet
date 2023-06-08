package com.final2.readytomeet.chat.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class ChatRoom {
    private String room_id;
    private String room_name;

    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.room_id = UUID.randomUUID().toString();
        chatRoom.room_name = name;
        return chatRoom;
    }
}