package com.example.course;

import com.example.course.model.Course;
import com.example.course.repository.CourseRepository;
import com.example.course.service.CourseUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseTest {

    @Autowired
    private CourseUserService courseUserService;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void show_courses() {
        List<Course> courseList = courseRepository.findAll();
        courseList.forEach(System.out::println);
    }

    @Test
    void filterCourse_test() {
        List<Course> courses = courseUserService.filterCourse("onlab", "basic", "Oliver");
        courses.forEach(System.out::println);
    }
}
