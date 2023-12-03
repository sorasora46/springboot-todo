package com.sora.todo.pojos.responses;

public class DeleteTodoData implements ResponseData {
    private String message;

    public DeleteTodoData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
