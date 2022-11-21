package com.example.courseproject.repository;

import com.example.courseproject.model.User;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private List<User> users;

    private final Faker faker;


    public UserRepository( Faker faker) {
        this.faker = faker;
        initUser();


    }
    private void  initUser(){
        users = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            User user = new User(i, faker.name().fullName(),
                    faker.internet().emailAddress(),
                    faker.phoneNumber().phoneNumber(),
                    faker.avatar().image());
            users.add(user);
        }
    }
    public List<User> findAll(){
        return users;

    }

    public Optional<User> findById(Integer userId) {
        return users.stream().filter(c -> c.getId() == userId).findFirst();
    }
}
