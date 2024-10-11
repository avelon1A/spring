package com.example.crud.spring.service.imp;

import com.example.crud.spring.dao.WebSocketMessageDao;
import com.example.crud.spring.entity.WebSocketMessageEntity;
import com.example.crud.spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final WebSocketMessageDao messageDao;

    @Autowired
    public MessageServiceImpl(WebSocketMessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public void saveMessage(WebSocketMessageEntity message) {
        messageDao.saveMessage(message);
    }

    @Override
    public List<WebSocketMessageEntity> getAllMessages() {
        return messageDao.getAllMessages();
    }
}

