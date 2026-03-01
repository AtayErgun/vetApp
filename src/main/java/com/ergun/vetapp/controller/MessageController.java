package com.ergun.vetapp.controller;

import com.ergun.vetapp.entity.Message;
import com.ergun.vetapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "http://localhost:5173")
public class MessageController {
    @Autowired
    private MessageRepository repository;
    @PostMapping
    public Message sendMessage(@RequestBody Message msg) { return repository.save(msg); }
}
