package com.sora.todo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sora.todo.exceptions.TodoException;
import com.sora.todo.models.Todo;
import com.sora.todo.pojos.requests.CreateTodoPayload;
import com.sora.todo.pojos.requests.UpdateTodoPayload;
import com.sora.todo.pojos.responses.AllTodosData;
import com.sora.todo.pojos.responses.CreateTodoData;
import com.sora.todo.pojos.responses.DeleteTodoData;
import com.sora.todo.pojos.responses.Response;
import com.sora.todo.pojos.responses.ResponseData;
import com.sora.todo.pojos.responses.TodoByIdData;
import com.sora.todo.pojos.responses.UpdateTodoData;
import com.sora.todo.services.TodoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = "/")
    public ResponseEntity<Response<AllTodosData>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();

        AllTodosData allTodos = new AllTodosData(todos);
        Response<AllTodosData> response = new Response<>(allTodos);
        HttpStatus httpStatus = response.getHttpStatus();

        return new ResponseEntity<>(response, httpStatus);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Response<? extends ResponseData>> getTodoById(@PathVariable Integer id) {
        Optional<Todo> todo = todoService.getTodoById(id);
        if (!todo.isPresent())
            throw new TodoException(id + " NOT FOUND", HttpStatus.NOT_FOUND);

        TodoByIdData todoByIdData = new TodoByIdData(todo.get());
        Response<TodoByIdData> response = new Response<>(todoByIdData);
        HttpStatus httpStatus = response.getHttpStatus();

        return new ResponseEntity<>(response, httpStatus);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Response<CreateTodoData>> createTodo(@RequestBody CreateTodoPayload payload) {
        Integer id = todoService.createTodo(payload);

        Response<CreateTodoData> response = new Response<>(true, new CreateTodoData(id), HttpStatus.CREATED);
        HttpStatus httpStatus = response.getHttpStatus();

        return new ResponseEntity<>(response, httpStatus);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Response<UpdateTodoData>> updateTodo(@PathVariable Integer id,
            @RequestBody UpdateTodoPayload payload) {
        Boolean isUpdated = todoService.updateTodo(id, payload);
        String message = isUpdated ? "UPDATE SUCCESS" : "UPDATE FAIL";

        if (!isUpdated)
            throw new TodoException(message + ": " + id + " NOT FOUND", HttpStatus.NOT_FOUND);

        Response<UpdateTodoData> response = new Response<>(isUpdated, new UpdateTodoData(message));
        HttpStatus httpStatus = response.getHttpStatus();

        return new ResponseEntity<>(response, httpStatus);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Response<DeleteTodoData>> deleteTodo(@PathVariable Integer id) {
        Boolean isDeleted = todoService.deleteTodo(id);
        String message = isDeleted ? "DELETE SUCCESS" : "DELETE FAIL";

        if (!isDeleted)
            throw new TodoException(message + ": " + id + " NOT FOUND", HttpStatus.NOT_FOUND);

        Response<DeleteTodoData> response = new Response<>(isDeleted, new DeleteTodoData(message));
        HttpStatus httpStatus = response.getHttpStatus();

        return new ResponseEntity<>(response, httpStatus);
    }

}
