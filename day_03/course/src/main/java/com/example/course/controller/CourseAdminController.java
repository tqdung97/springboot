package com.example.course.controller;

import com.example.course.dto.CourseDto;
import com.example.course.request.UpsertCourseRequest;
import com.example.course.response.ErrorResponse;
import com.example.course.response.page.PageInfoResponse;
import com.example.course.response.page.PageInfoResponseImpl;
import com.example.course.service.CourseAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/admin/courses")
@RequiredArgsConstructor
public class CourseAdminController {
    private final CourseAdminService courseAdminService;

    @GetMapping("")
    public PageInfoResponse<CourseDto> getAllCourse(@RequestParam(required = false, defaultValue = "1") Integer page,
                                          @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return courseAdminService.getAllCourse(page, pageSize);
    }

    @GetMapping("{id}")
    public CourseDto getCourseById(@PathVariable Integer id) {
        return courseAdminService.getCourseById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDto createCourse(@Valid @RequestBody UpsertCourseRequest request) {
        return courseAdminService.createCourse(request);
    }

    @PutMapping("{id}")
    public CourseDto updateCourse(@Valid @RequestBody UpsertCourseRequest request, @PathVariable Integer id) {
        return courseAdminService.updateCourse(id, request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Integer id) {
        courseAdminService.deleteCourse(id);
    }
}
