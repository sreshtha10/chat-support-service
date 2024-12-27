package com.sreshtha.chat_support.model;

public class Message {
    private String senderId; // ID of the sender (could be a customer or an agent)
    private String content;  // Content of the message
    private long timestamp;  // Timestamp of when the message was sent

    public Message() {}

    public Message(String senderId, String content) {
        this.senderId = senderId;
        this.content = content;
        this.timestamp = System.currentTimeMillis(); // Set the current time as the message timestamp
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}