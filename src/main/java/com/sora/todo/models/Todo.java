package com.sora.todo.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @SequenceGenerator(name = "seq-gen", sequenceName = "id", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq-gen")
    private Integer id;

    private String todo;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public Todo() {
    }

    public Todo(String todo) {
        this.todo = todo;
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    public Todo(Integer id, String todo) {
        this(todo);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
