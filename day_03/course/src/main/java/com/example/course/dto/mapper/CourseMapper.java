package com.example.course.dto.mapper;

import com.example.course.dto.CourseDto;
import com.example.course.exception.NotFoundException;
import com.example.course.model.Course;
import com.example.course.model.User;
import com.example.course.repository.UserRepository;
import com.example.course.request.UpsertCourseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseMapper {
    private final UserRepository userRepository;

    public CourseDto toCourseDto(Course course) {
        User user = userRepository.findById(course.getUserId())
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found user");
                });

        return CourseDto.builder()
                .id(course.getId())
                .name(course.getName())
                .description(course.getDescription())
                .type(course.getType())
                .topics(course.getTopics())
                .thumbnail(course.getThumbnail())
                .user(user)
                .build();
    }

    public Course toCourse(UpsertCourseRequest request) {
        return Course.builder()
                .name(request.getName())
                .description(request.getDescription())
                .type(request.getType())
                .topics(request.getTopics())
                .thumbnail(request.getThumbnail())
                .userId(request.getUserId())
                .build();
    }
}
