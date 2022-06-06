package com.sample.chat.Dto;

import com.sample.chat.Enum.MessageType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ChatMessage {
    private String chatRoomId;
    private String writer;
    private String message;
    private MessageType type;
}
