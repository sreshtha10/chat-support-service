package com.sreshtha.chat_support.controller;

import com.sreshtha.chat_support.model.Chat;
import com.sreshtha.chat_support.service.ChatSupportService;
import com.sreshtha.chat_support.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat-support")
public class ChatSupportController {

    @Autowired
    private ChatSupportService chatSupportService;

    @Autowired
    private ScoresService scoresService;

    @PostMapping("/send-chat")
    public String sendChat(@RequestBody Chat chat) {
        return chatSupportService.saveChat(chat);
    }

    @GetMapping("/health")
    public String health() {
        return "Chat Support Service is up and running";
    }
}