package com.example.blogbackend.controller;

import com.example.blogbackend.request.UpsertUserRequest;
import com.example.blogbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;

    // Xem danh sách User
    @GetMapping("")
    public ResponseEntity<?> getAllUsers() {
       return ResponseEntity.ok(userService.getAllUser());
    }
    // Xem chi tiết User
    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    // Tạo User
    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody UpsertUserRequest request) {
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }

    // Sửa User
    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UpsertUserRequest request){
        return ResponseEntity.ok(userService.updateUser(id, request));
    }
    // Xóa User
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
