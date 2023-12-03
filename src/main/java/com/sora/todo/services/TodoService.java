package com.sora.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sora.todo.models.Todo;
import com.sora.todo.repositories.TodoRepository;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Integer id) {
        return todoRepository.findById(id);
    }

    public Integer createTodo(String todo) {
        var newTodo = new Todo(todo);
        Todo result = todoRepository.save(newTodo);

        return result.getId();
    }

    public Boolean updateTodo(Integer id, String update) {
        Boolean isTodoExist = todoRepository.existsById(id);

        if (!isTodoExist)
            return false;

        Todo updatedTodo = new Todo(id, update);

        todoRepository.save(updatedTodo);

        return true;
    }

    public Boolean deleteTodo(Integer id) {
        Boolean isTodoExist = todoRepository.existsById(id);

        if (!isTodoExist)
            return false;

        todoRepository.deleteById(id);
        Boolean isTodoDeleted = todoRepository.existsById(id);

        if (isTodoDeleted)
            return false;

        return true;
    }
}