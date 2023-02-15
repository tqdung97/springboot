package com.example.miniproject.repository;

import com.example.miniproject.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByStatus(boolean status);
    List<Todo> findAllByTitle(String title);
    // Lấy entity => map sang dto tương ứng
    List<Todo> findByTitleStartingWith(String prefix);
}