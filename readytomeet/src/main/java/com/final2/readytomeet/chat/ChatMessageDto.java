package com.final2.readytomeet.chat;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ChatMessageDto {

    private String username;
    private String message;
    private LocalDateTime timestamp;

    // constructors, getters, and setters
}
