package com.sora.todo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    @GetMapping(value = "/")
    public String getAllTodos() {
        return "All Todos\n";
    }

    @GetMapping(value = "/{id}")
    public String getTodoById(@PathVariable Integer id) {
        return id + "\n";
    }

    @PostMapping(value = "/create")
    public String createTodo(@RequestBody String todo) {
        return todo + "\n";
    }

    @PutMapping(value = "/update/{id}")
    public String updateTodo(@PathVariable Integer id, @RequestBody String update) {
        return id + ": " + update + "\n";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTodo(@PathVariable Integer id) {
        return id + "\n";
    }

}
