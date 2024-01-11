package com.example.demo;

import com.example.demo.entity.Message;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class HomeController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping({"/", "/home", "/status"})
    public ResponseEntity<String> getStatus() {
        return messageRepository.findById(1L)
                .map(Message::getContent)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found"));
    }

}
