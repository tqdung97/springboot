package com.example.blogbackend.controller;

import com.example.blogbackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentController {


    @Autowired
    private CommentService commentService;

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);return ResponseEntity.noContent().build();
    }
}
