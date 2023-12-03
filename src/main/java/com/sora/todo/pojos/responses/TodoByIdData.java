package com.sora.todo.pojos.responses;

import com.sora.todo.models.Todo;

public class TodoByIdData implements ResponseData {
    private Todo todo;

    public TodoByIdData(Todo todo) {
        this.todo = todo;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }
}
