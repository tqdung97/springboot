package com.example.course.db;

import com.example.course.model.Course;
import com.example.course.model.User;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class InitData {
    private final Faker faker;

    public List<User> initUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            User user = new User(
                    i,
                    faker.name().fullName(),
                    faker.internet().emailAddress(),
                    faker.phoneNumber().phoneNumber(),
                    faker.avatar().image());
            users.add(user);
        }
        return users;
    }

    public List<Course> initCourses(List<User> users) {
        List<Course> courses = new ArrayList<>();

        Random rd = new Random();
        List<String> topics = List.of("frontend", "backend", "database", "devops", "AWS", "basic", "mobile");

        for (int i = 1; i < 21; i++) {
            // Random topic
            List<String> rdTopics = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                String rdTopic = topics.get(rd.nextInt(topics.size()));
                if (!rdTopics.contains(rdTopic)) {
                    rdTopics.add(rdTopic);
                }
            }

            // Random user
            User rdUser = users.get(rd.nextInt(users.size()));

            // Tạo khóa học
            Course course = new Course(
                    i,
                    faker.funnyName().name(),
                    faker.lorem().sentence(20),
                    rd.nextInt(2) == 1 ? "online" : "onlab",
                    rdTopics,
                    faker.avatar().image(),
                    rdUser.getId()
            );

            courses.add(course);
        }

        return courses;
    }
}
