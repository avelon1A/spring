package com.example.crud.spring.repository;


import com.example.crud.spring.entity.WebSocketMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebSocketMessageRepository extends JpaRepository<WebSocketMessageEntity, Long> {
}
