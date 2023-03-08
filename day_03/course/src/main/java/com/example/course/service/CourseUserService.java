package com.example.course.service;

import com.example.course.dto.CourseDto;
import com.example.course.dto.mapper.CourseMapper;
import com.example.course.exception.NotFoundException;
import com.example.course.model.Course;
import com.example.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseUserService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    // 1. Lấy danh sách course (có lọc dữ liệu)
    public List<CourseDto> filterCourse(String type, String topic, String name) {
        return courseRepository.findAll()
                .stream()
                .filter(course -> (type == null || course.getType().equals(type))
                        && (name == null || course.getName().contains(name))
                        && (topic == null || course.getTopics().contains(topic)))
                .map(courseMapper::toCourseDto)
                .toList();
    }

    // 2. Lấy chi tiết course
    public CourseDto getCourseById(Integer id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found course");
                });

        return courseMapper.toCourseDto(course);
    }
}
