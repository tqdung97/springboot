package com.example.courseproject.repository;

import com.example.courseproject.exception.NotFoundException;
import com.example.courseproject.model.Course;
import com.example.courseproject.model.User;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class CourseRepository {
    private List<Course> courses ;
    private final UserRepository userRepository;
    private final Faker faker;

    public CourseRepository( UserRepository userRepository, Faker faker) {

        this.userRepository = userRepository;
        this.faker = faker;
        initCourse();
    }

    private void initCourse(){
        courses = new ArrayList<>();
        Random rd= new Random();
        List<String> topics = List.of("Java", "Spring", "DataBase", "DevOps", "Font-End", "Back-End");
        List<User> users = userRepository.findAll();
        for (int i = 1; i < 11; i++) {
            List<String> rdTopics = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                String rdTopic = topics.get(rd.nextInt(topics.size()));
                if (!rdTopics.contains(rdTopic)) {
                    rdTopics.add(rdTopic);
                }
            }
            User rdUser = users.get(rd.nextInt(users.size()));
            Course course = new Course(i,
                    faker.funnyName().name(),
                    faker.lorem().sentence(10),
                    rd.nextInt(2) == 1 ? "Online" : "OnLab",
                    rdTopics,
                    faker.avatar().image(),
                    rdUser.getId());
            courses.add(course);
        }
    }
    public List<Course> findAll() {
        return courses;
    }

    public Optional<Course> findById(Integer id) {
        return courses.stream().filter(c -> c.getId() == id).findFirst();
    }

    public Course saveCourse(Course course) {
        int id = courses.get(courses.size() - 1).getId() + 1;
        course.setId(id);
        courses.add(course);
        return course;
    }

    public void deleteById(Integer id) {
        Course course = findById(id).orElseThrow(() -> new NotFoundException("Id is not existed " + id));
        courses.remove(course);
    }
}
