package com.example.blogbackend.service;

import com.example.blogbackend.entity.Comment;
import com.example.blogbackend.exception.NotFoundException;
import com.example.blogbackend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void deleteComment(Integer id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found Comment with id " + id);
        });
        commentRepository.delete(comment);
    }
}
