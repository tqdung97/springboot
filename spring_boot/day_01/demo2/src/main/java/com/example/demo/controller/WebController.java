package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    // path: GET/api/helloWorld => hello world
    @GetMapping("/api/helloWorld")
    public  String getHello(){
        return "hello world";
    }
}
