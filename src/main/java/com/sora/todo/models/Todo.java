package com.sora.todo.models;

import java.time.LocalDateTime;

public class Todo {
    private Integer id;
    private String todo;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    Todo() {
    }

    Todo(String todo) {
        this.todo = todo;
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

}
