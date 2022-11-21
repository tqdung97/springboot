package com.example.courseproject.service;

import com.example.courseproject.exception.NotFoundException;
import com.example.courseproject.model.Course;
import com.example.courseproject.repository.CourseRepository;
import com.example.courseproject.repository.UserRepository;
import com.example.courseproject.request.UpsertCourse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AdminService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public AdminService(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }


    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }

    public Course save(UpsertCourse upsertCourse) {
        Course newCourse = new Course(0,
                upsertCourse.getName(),
                upsertCourse.getDescription(),
                upsertCourse.getType(),
                upsertCourse.getTopics(),
                upsertCourse.getThumbnail(),
                upsertCourse.getUserId()
        );
        return courseRepository.saveCourse(newCourse);
    }

    public Course updateCourse(UpsertCourse upsertCourse, Integer id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new NotFoundException("This id is not existed, id= " + id));
        if (upsertCourse.getName() != null ) course.setName(upsertCourse.getName());
        if(upsertCourse.getDescription() != null) course.setDescription(upsertCourse.getDescription());
        if(upsertCourse.getThumbnail() != null) course.setThumbnail(upsertCourse.getThumbnail());
        if (upsertCourse.getTopics() != null) course.setTopics(upsertCourse.getTopics());
        if (upsertCourse.getType() != null) course.setType(upsertCourse.getType());
        if (upsertCourse.getUserId() != null) course.setUserId(upsertCourse.getUserId());

        return course;
    }

    public ResponseEntity<Void> deleteCourse(Integer id) {
        courseRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
