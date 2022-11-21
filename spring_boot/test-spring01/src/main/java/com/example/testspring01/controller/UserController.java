package com.example.testspring01.controller;

import com.example.testspring01.model.User;
import com.example.testspring01.request.UserRequest;
import com.example.testspring01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @GetMapping("{name}")
    public UserRequest getUserByName(@PathVariable String name){
        return userService.getUserByName(name);
    }
    @GetMapping("{id}")
    public UserRequest getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
    @PostMapping("")
    public User createUser(@RequestBody @Valid UserRequest upsertUser) {
        return userService.createUser(upsertUser);
    }

    @PutMapping("{id}")
    public User updateUser (@RequestBody UserRequest userRequest,
                                @PathVariable Integer id) {
        return userService.updateUser(userRequest, id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

}
