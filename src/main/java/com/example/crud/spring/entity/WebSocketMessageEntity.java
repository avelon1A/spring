package com.example.crud.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class WebSocketMessageEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String message;

    public WebSocketMessageEntity() {}

    public WebSocketMessageEntity(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
