package com.example.demo.database;

import com.example.demo.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    public static List<User> users = new ArrayList<>(List.of(
            new User(1,"tqdung1","tqdung2301@gmail.com","1a1a","Smile"),
            new User(2,"tqdung2","vn997th@gmail.com","2b2b","Avatar"),
            new User(3,"tqdung3","kinganime110i@gmail.com","3c3c","Avatar2")));
}
