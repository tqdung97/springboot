package com.example.course.controller;

import com.example.course.dto.CourseDto;
import com.example.course.service.CourseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
@RequiredArgsConstructor
public class CourseUserController {
    private final CourseUserService courseUserService;

    @GetMapping("")
    public List<CourseDto> getAllCourse(@RequestParam(required = false) String type,
                                        @RequestParam(required = false) String name,
                                        @RequestParam(required = false) String topic) {
        return courseUserService.filterCourse(type, topic, name);
    }

    @GetMapping("{id}")
    public CourseDto getCourseById(@PathVariable Integer id) {
        return courseUserService.getCourseById(id);
    }
}
