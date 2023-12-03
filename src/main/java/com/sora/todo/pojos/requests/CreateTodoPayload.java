package com.sora.todo.pojos.requests;

public class CreateTodoPayload {
    private String todo;

    public CreateTodoPayload() {
    }

    public CreateTodoPayload(String todo) {
        this.todo = todo;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
