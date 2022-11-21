package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BMIController {
    @GetMapping("/BMI")
    public  Double height(@RequestParam double height,@RequestParam double weight){
        return null;
    }
}
