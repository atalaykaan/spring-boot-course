package com.atalay.learn_spring_security.model;

public class Todo {

    private String username;

    private String description;

    public Todo(String username, String description) {
        this.username = username;
        this.description = description;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
