package com.sora.todo.pojos.requests;

public class UpdateTodoPayload {
    private String update;

    public UpdateTodoPayload() {
    }

    public UpdateTodoPayload(String update) {
        this.update = update;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }
}
