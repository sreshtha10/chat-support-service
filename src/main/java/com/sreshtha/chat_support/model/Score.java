package com.sreshtha.chat_support.model;

import com.sreshtha.chat_support.constants.ApplicationConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = ApplicationConstants.SCORES_COLLECTION_NAME)
public class Score {
    @Id
    private String id;
    private String chatId;
    private double score;

    public Score() {}

    public Score(String chatId, double score) {
        this.chatId = chatId;
        this.score = score;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}