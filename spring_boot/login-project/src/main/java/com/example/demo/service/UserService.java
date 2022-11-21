package com.example.demo.service;

import com.example.demo.exception.ErrorMessage;
import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.UserErrorMessage;
import com.example.demo.model.User;
import com.example.demo.reponse.UserReponse;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    UserReponse userReponse;


    public UserReponse findByUserAndPassword(String username,String password) {
        Optional<User> user = userRepository.findByUserAndPassword(username,password);
        if(user.isEmpty()){
            throw new NotFoundException("userName,password chưa đúng hoặc chưa tồn tại");
        }
        userReponse.setUserName(user.get().getUserName());
        userReponse.setEmail(user.get().getEmail());
        userReponse.setAvatar(user.get().getAvatar());
        return userReponse;
    }

    public List<User> getAllUser(){

    }

}
