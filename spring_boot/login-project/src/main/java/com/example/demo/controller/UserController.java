package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.reponse.UserReponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public UserReponse login(@RequestBody User user) {
        return userService.findByUserAndPassword(user.getUserName(),user.getPassword());
    }
    @GetMapping
    public List<User> getAllUser(){
        return null;
    }

}
