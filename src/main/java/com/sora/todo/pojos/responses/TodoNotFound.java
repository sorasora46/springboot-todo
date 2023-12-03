package com.sora.todo.pojos.responses;

public class TodoNotFound implements ResponseData {
    private String message;

    public TodoNotFound(Integer id) {
        this.message = id + ": NOT FOUND";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
