package com.example.miniproject.service;

import com.example.miniproject.exception.BadRequestException;
import com.example.miniproject.exception.NotFoundException;
import com.example.miniproject.model.Todo;
import com.example.miniproject.repository.TodoRepository;
import com.example.miniproject.request.CreateTodoRequest;
import com.example.miniproject.request.UpdateTodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public Todo createTodo(CreateTodoRequest request) {
        if(request.getTitle().trim().length() == 0) {
            throw new BadRequestException("Tiêu đề không được để trống");
        }
        Todo todo = new Todo();
        todo.setTitle(request.getTitle());

        return todoRepository.save(todo);
    }

    public Todo updateTodo(int id, UpdateTodoRequest request) {
        if(request.getTitle().trim().length() == 0) {
            throw new BadRequestException("Tiêu đề không được để trống");
        }

        Todo todo = todoRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Không tồn tại todo có id = " + id);
        });

        todo.setTitle(request.getTitle());
        todo.setStatus(request.isStatus());

        return todoRepository.save(todo);
    }

    public void deleteTodo(int id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Không tồn tại todo có id = " + id);
        });

        todoRepository.delete(todo);
    }
}
