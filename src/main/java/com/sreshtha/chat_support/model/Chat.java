package com.sreshtha.chat_support.model;


import com.sreshtha.chat_support.constants.ApplicationConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = ApplicationConstants.CHAT_COLLECTION_NAME)
public class Chat {
    @Id
    private String id;
    private String customerName;
    private String customerId;
    private String agentName;
    private String agentId;
    private long timestamp;
    private List<Message> messages;

    public Chat() {}

    public Chat(String customerName, String customerId, String agentName, String agentId) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.agentName = agentName;
        this.agentId = agentId;
        this.timestamp = System.currentTimeMillis(); // Set the current time as the chat timestamp
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

}