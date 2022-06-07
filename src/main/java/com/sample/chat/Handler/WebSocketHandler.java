package com.sample.chat.Handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.chat.Dto.ChatMessage;
import com.sample.chat.Dto.ChatRoom;
import com.sample.chat.Repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {
    private final ChatRoomRepository chatRoomRepository;
    private final ObjectMapper objectMapper;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("메세지 전송 = {} : {}",session,message.getPayload());
        String msg = message.getPayload();

        //json형태를 chatMessage 자바오브젝트 형태로 변환
        ChatMessage chatMessage = objectMapper.readValue(msg,ChatMessage.class);

        ChatRoom chatRoom = chatRoomRepository.findRoomById(chatMessage.getChatRoomId());

        chatRoom.handleMessage(session,chatMessage,objectMapper);
    }
}
