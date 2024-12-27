package com.sreshtha.chat_support.controller;

import com.sreshtha.chat_support.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/scores")
public class ScoresController {

    @Autowired
    private ScoresService scoresService;

    @GetMapping("/health")
    public String health() {
        return "Scores Service is up and running";
    }

    @GetMapping("/chat-score")
    public double getChatScore(@RequestParam String chatId) {
        return scoresService.getChatScore(chatId);
    }

}