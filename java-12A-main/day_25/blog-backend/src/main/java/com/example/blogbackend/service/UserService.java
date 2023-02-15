package com.example.blogbackend.service;

import com.example.blogbackend.entity.User;
import com.example.blogbackend.exception.NotFoundException;
import com.example.blogbackend.repository.UserRepository;
import com.example.blogbackend.request.UpsertUserRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
    }
    @Transactional
    public User createUser(UpsertUserRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .avatar(request.getAvatar())
                .password(request.getPassword())
                .build();
        return userRepository.save(user);
    }
    @Transactional
    public User updateUser(Integer id, UpsertUserRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found blog with id = " + id);
        });
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setAvatar(request.getAvatar());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }
    @Transactional
    public void deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found blog with id = " + id);
        });
        userRepository.delete(user);
    }
}
