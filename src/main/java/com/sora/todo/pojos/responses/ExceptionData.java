package com.sora.todo.pojos.responses;

public class ExceptionData implements ResponseData {
    private String message;

    public ExceptionData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
