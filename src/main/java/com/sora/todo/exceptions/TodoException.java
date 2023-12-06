package com.sora.todo.exceptions;

import org.springframework.http.HttpStatus;

public class TodoException extends RuntimeException {

    private HttpStatus httpStatus;

    public TodoException() {
    }

    public TodoException(String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public TodoException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

}
