package com.sora.todo.pojos.responses;

import java.util.List;

import com.sora.todo.models.Todo;

public class AllTodosData implements ResponseData {
    private List<Todo> todos;

    public AllTodosData(List<Todo> todos) {
        this.todos = todos;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
