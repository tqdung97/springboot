package com.example.courseproject.controller;

import com.example.courseproject.dto.CourseDetailDTO;
import com.example.courseproject.model.Course;
import com.example.courseproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/course")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping()
    public List<Course> getAll(
            @Valid @RequestParam(value = "type", required = false) String typeValue,
            @RequestParam(value = "name", required = false) String nameValue,
            @RequestParam(value = "topic", required = false) String topicValue)
    {
        return userService.findAll(typeValue,nameValue,topicValue);

    }
    @GetMapping("{id}")
    public CourseDetailDTO findCourseById(@PathVariable Integer id){
        return userService.findById(id);
    }
}
