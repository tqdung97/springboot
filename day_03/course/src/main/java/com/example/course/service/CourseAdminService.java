package com.example.course.service;

import com.example.course.dto.CourseDto;
import com.example.course.dto.mapper.CourseMapper;
import com.example.course.exception.NotFoundException;
import com.example.course.model.Course;
import com.example.course.repository.CourseRepository;
import com.example.course.request.UpsertCourseRequest;
import com.example.course.response.ErrorResponse;
import com.example.course.response.page.PageInfoResponse;
import com.example.course.response.page.PageInfoResponseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseAdminService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    // 1. Lấy danh sách course có phân trang
    public PageInfoResponse<CourseDto> getAllCourse(Integer page, Integer pageSize) {
        List<Course> courses = courseRepository.findAll();
        List<CourseDto> courseDtos = courses.stream()
                .map(courseMapper::toCourseDto)
                .toList();
        return new PageInfoResponseImpl<>(courseDtos, page - 1, pageSize);
    }

    // 2. Lấy chi tiết course
    public CourseDto getCourseById(Integer id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found course");
                });

        return courseMapper.toCourseDto(course);
    }

    // 3. Tạo course mới
    public CourseDto createCourse(UpsertCourseRequest request) {
        Course course = courseMapper.toCourse(request);
        return courseMapper.toCourseDto(courseRepository.save(course));
    }

    // 4. Cập nhật course
    public CourseDto updateCourse(Integer id, UpsertCourseRequest request) {
        Course course = courseRepository.update(id, request);
        return courseMapper.toCourseDto(course);
    }

    // Xóa course
    public void deleteCourse(Integer id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found course");
                });

        courseRepository.delete(course);
    }
}
