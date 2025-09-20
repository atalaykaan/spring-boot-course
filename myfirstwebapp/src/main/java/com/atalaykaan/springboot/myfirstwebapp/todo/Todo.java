package com.atalaykaan.springboot.myfirstwebapp.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;

    @Size(min = 10, message = "Description must be at least 10 characters.")
    private String description;
    private LocalDate dateToComplete;
    private boolean done;

    public Todo() {

    }

    public Todo(int id, String username, String description, LocalDate dateToComplete, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.dateToComplete = dateToComplete;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateToComplete() {
        return dateToComplete;
    }

    public void setDateToComplete(LocalDate dateToComplete) {
        this.dateToComplete = dateToComplete;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", dateToComplete=" + dateToComplete +
                ", done=" + done +
                '}';
    }
}
