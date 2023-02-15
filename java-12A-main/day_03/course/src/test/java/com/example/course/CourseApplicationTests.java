package com.example.course;

import com.example.course.model.Course;
import com.example.course.model.User;
import com.example.course.repository.CourseRepository;
import com.example.course.repository.UserRepository;
import com.github.slugify.Slugify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private Slugify slugify;

    @Test
    void show_users() {
        List<User> userList = userRepository.findAll();
        userList.forEach(System.out::println);
    }

    @Test
    void show_courses() {
        List<Course> courseList = courseRepository.findAll();
        courseList.forEach(System.out::println);
    }

    @Test
    void test_slug() {
        System.out.println(slugify.slugify("một ngày, nào đó"));
    }
}
