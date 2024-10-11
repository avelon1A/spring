package com.example.crud.spring.service;

import com.example.crud.spring.entity.WebSocketMessageEntity;

import java.util.List;

public interface MessageService {
    void saveMessage(WebSocketMessageEntity message);
    List<WebSocketMessageEntity> getAllMessages();

}
