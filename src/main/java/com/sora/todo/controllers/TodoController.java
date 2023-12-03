package com.sora.todo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sora.todo.models.Todo;
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
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping(value = "/{id}")
    public Optional<Todo> getTodoById(@PathVariable Integer id) {
        return todoService.getTodoById(id);
    }

    @PostMapping(value = "/create")
    public Integer createTodo(@RequestBody String todo) {
        return todoService.createTodo(todo);
    }

    @PutMapping(value = "/update/{id}")
    public Boolean updateTodo(@PathVariable Integer id, @RequestBody String update) {
        return todoService.updateTodo(id, update);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean deleteTodo(@PathVariable Integer id) {
        return todoService.deleteTodo(id);
    }

}
