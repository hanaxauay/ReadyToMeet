package com.final2.readytomeet.chat.repository;

import com.final2.readytomeet.chat.dto.ChatRoom;
import com.final2.readytomeet.chat.mapper.ChatRoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class ChatRoomRepository {

    private final ChatRoomMapper chatRoomMapper;

    public ChatRoomRepository(ChatRoomMapper chatRoomMapper) {
        this.chatRoomMapper = chatRoomMapper;
    }

    @PostConstruct
    private void init() {
        // 초기화 작업 수행
    }

    public List<ChatRoom> findAllRoom() {
        return chatRoomMapper.findAllRoom();
    }

    public ChatRoom getChatRoomById(int appo_seq) {
        return chatRoomMapper.getChatRoomById(appo_seq);
    }


    public ChatRoom createChatRoom(int appo_seq, String name) {
        ChatRoom chatRoom = ChatRoom.create(appo_seq, name);
        chatRoomMapper.createChatRoom(chatRoom);
        return chatRoom;
    }

    public int deleteChatRoom(int appo_seq) {
        return chatRoomMapper.deleteChatRoomByAppoSeq(appo_seq);
    }

}
