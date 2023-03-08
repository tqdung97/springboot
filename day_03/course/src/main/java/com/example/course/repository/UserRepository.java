package com.example.course.repository;

import com.example.course.db.UserDB;
import com.example.course.model.User;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    public List<User> findAll() {
        return UserDB.users;
    }

    public Optional<User> findById(Integer id) {
        return UserDB.users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
}
