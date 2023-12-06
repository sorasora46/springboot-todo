package com.sora.todo.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sora.todo.exceptions.TodoException;
import com.sora.todo.pojos.responses.ExceptionData;
import com.sora.todo.pojos.responses.Response;
import com.sora.todo.pojos.responses.ResponseData;

@ControllerAdvice
public class TodoExceptionAdvice {
    public TodoExceptionAdvice() {
    }

    @ExceptionHandler(TodoException.class)
    public ResponseEntity<Response<? extends ResponseData>> todoException(TodoException ex) {
        String errorMessage = ex.getMessage();
        HttpStatus httpStatus = ex.getHttpStatus();

        Response<ExceptionData> response = new Response<>(false, new ExceptionData(errorMessage), httpStatus);

        return new ResponseEntity<>(response, httpStatus);
    }
}
