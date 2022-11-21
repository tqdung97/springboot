package com.example.demo.repository;

import com.example.demo.model.User;
import com.example.demo.database.UserDB;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    public Optional<User> findByUserAndPassword (String username , String password){
        return UserDB.users
                .stream()
                .filter(user -> user.getUserName().equals(username) && user.getPassword().equals(password))
                .findFirst();
    }
}
