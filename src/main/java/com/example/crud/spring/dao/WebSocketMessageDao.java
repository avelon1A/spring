package com.example.crud.spring.dao;


import com.example.crud.spring.entity.WebSocketMessageEntity;

import java.util.List;

public interface WebSocketMessageDao {
    void saveMessage(WebSocketMessageEntity message);
    List<WebSocketMessageEntity> getAllMessages();
}
