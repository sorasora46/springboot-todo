package com.sora.todo.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sora.todo.models.Todo;
import com.sora.todo.pojos.requests.CreateTodoPayload;
import com.sora.todo.pojos.requests.UpdateTodoPayload;
import com.sora.todo.repositories.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Integer id) {
        return todoRepository.findById(id);
    }

    public Integer createTodo(CreateTodoPayload payload) {
        var newTodo = new Todo(payload.getTodo());
        Todo result = todoRepository.save(newTodo);

        return result.getId();
    }

    public Boolean updateTodo(Integer id, UpdateTodoPayload payload) {
        Optional<Todo> oldTodo = todoRepository.findById(id);
        if (!oldTodo.isPresent())
            return false;

        var todo = oldTodo.get();

        todo.setTodo(payload.getUpdate());
        todo.setUpdatedDate(LocalDateTime.now());

        todoRepository.save(todo);

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