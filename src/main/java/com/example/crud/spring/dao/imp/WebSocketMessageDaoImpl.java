package com.example.crud.spring.dao.imp;


import com.example.crud.spring.dao.WebSocketMessageDao;
import com.example.crud.spring.entity.WebSocketMessageEntity;
import com.example.crud.spring.repository.WebSocketMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WebSocketMessageDaoImpl implements WebSocketMessageDao {

    private final WebSocketMessageRepository messageRepository;

    @Autowired
    public WebSocketMessageDaoImpl(WebSocketMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void saveMessage(WebSocketMessageEntity message) {
        messageRepository.save(message);
    }

    @Override
    public List<WebSocketMessageEntity> getAllMessages() {
        return messageRepository.findAll();
    }
}
