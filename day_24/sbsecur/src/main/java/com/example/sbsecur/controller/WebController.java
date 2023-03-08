package com.example.sbsecur.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebController {
    @GetMapping("home")
    public ResponseEntity<?> getHome() {
        return ResponseEntity.ok("home");
    }
}
