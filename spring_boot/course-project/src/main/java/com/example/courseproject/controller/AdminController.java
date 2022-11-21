package com.example.courseproject.controller;

import com.example.courseproject.dto.CourseDetailDTO;
import com.example.courseproject.model.Course;
import com.example.courseproject.request.UpsertCourse;
import com.example.courseproject.service.AdminService;
import com.example.courseproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("admin")     // context-path: /api/v1/
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final UserService userService;

    @GetMapping("/courses")
    public List<Course> findAllCourses () {
        return adminService.findAllCourse();
    }

    @GetMapping("/courses/{id}")
    public CourseDetailDTO findDetailCourse(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/courses")
    public Course createCourse(@RequestBody @Valid UpsertCourse upsertCourse) {
        return adminService.save(upsertCourse);
    }

    @PutMapping("/courses/{id}")
    public Course updateCourse (@RequestBody UpsertCourse upsertCourse,
                                @PathVariable Integer id) {
        return adminService.updateCourse(upsertCourse, id);
    }

    @DeleteMapping("courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        return adminService.deleteCourse(id);
    }
}
