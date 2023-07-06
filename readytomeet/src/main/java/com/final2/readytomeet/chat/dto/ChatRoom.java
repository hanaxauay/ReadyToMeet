package com.final2.readytomeet.chat.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatRoom {

    private int appo_seq;
    private String room_name;

    public static ChatRoom create(int appoSeq, String roomName) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setAppo_seq(appoSeq);
        chatRoom.setRoom_name(roomName);
        return chatRoom;
    }
}