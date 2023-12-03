package com.sora.todo.pojos.responses;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Response<T extends ResponseData> {
    private Boolean success;
    private T result;
    private HttpStatus httpStatus;

    public Response(T result) {
        this.success = true;
        this.result = result;
        this.httpStatus = HttpStatus.OK;
    }

    public Response(Boolean success, T result) {
        this.success = success;
        this.result = result;

        if (!success) {
            this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
            this.httpStatus = HttpStatus.OK;
        }
    }

    public Response(Boolean success, T result, HttpStatus httpStatus) {
        this.success = success;
        this.result = result;
        this.httpStatus = httpStatus;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @JsonIgnore
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @JsonIgnore
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

}
