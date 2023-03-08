package com.example.miniproject.service;

import com.example.miniproject.model.Todo;
import com.example.miniproject.request.CreateTodoRequest;
import com.example.miniproject.request.UpdateTodoRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private List<Todo> todos;

    public TodoService() {
        todos = new ArrayList<>();
        todos.add(new Todo(1, "Đi chơi", true));
        todos.add(new Todo(2, "Làm bài tập", false));
        todos.add(new Todo(3, "Đá bóng", true));
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public Todo createTodo(CreateTodoRequest request) {
        return null;
    }

    public Todo updateTodo(int id, UpdateTodoRequest request) {
        return null;
    }

    public void deleteTodo(int id) {}

    private Optional<Todo> findById(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst();
    }
}
