package com.sreshtha.chat_support.model;

import com.sreshtha.chat_support.constants.ApplicationConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = ApplicationConstants.USER_COLLECTION_NAME)
public class User {
    @Id
    private String id;
    private String name;
    private Role role;
    private double score=0;

    public User(){}

    public User(String id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public User(String id, String name, Role role, double score) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}