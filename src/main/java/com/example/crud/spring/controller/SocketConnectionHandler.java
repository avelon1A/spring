package com.example.crud.spring.controller;

import com.example.crud.spring.entity.WebSocketMessageEntity;
import com.example.crud.spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SocketConnectionHandler extends TextWebSocketHandler {

    private final MessageService messageRepository;
    private final List<WebSocketSession> webSocketSessions = Collections.synchronizedList(new ArrayList<>());

    @Autowired
    public SocketConnectionHandler(MessageService messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        System.out.println(session.getId() + " Connected");
        webSocketSessions.add(session);
        List<WebSocketMessageEntity> previousMessages = messageRepository.getAllMessages();
        for (WebSocketMessageEntity messageEntity : previousMessages) {
            session.sendMessage(new TextMessage(messageEntity.getMessage()));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        System.out.println(session.getId() + " DisConnected");
        webSocketSessions.remove(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        super.handleMessage(session, message);

        WebSocketMessageEntity messageEntity = new WebSocketMessageEntity(message.getPayload().toString());
        messageRepository.saveMessage(messageEntity);

        for (WebSocketSession webSocketSession : webSocketSessions) {
            if (session == webSocketSession) continue;
            webSocketSession.sendMessage(message);
        }
    }
}
