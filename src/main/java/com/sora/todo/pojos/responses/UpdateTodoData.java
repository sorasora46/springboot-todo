package com.sora.todo.pojos.responses;

public class UpdateTodoData implements ResponseData {
    private String message;

    public UpdateTodoData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
