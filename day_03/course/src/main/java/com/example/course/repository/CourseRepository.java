package com.example.course.repository;

import com.example.course.db.CourseDB;
import com.example.course.db.UserDB;
import com.example.course.exception.NotFoundException;
import com.example.course.model.Course;
import com.example.course.model.User;
import com.example.course.request.UpsertCourseRequest;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class CourseRepository {
    private Integer nextId() {
        List<Course> courses = CourseDB.courses;
        if(courses.isEmpty()) {
            return 1;
        }
        return courses.get(courses.size() - 1).getId() + 1;
    }

    public List<Course> findAll() {
        return CourseDB.courses;
    }

    public Optional<Course> findById(Integer id) {
        return CourseDB.courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst();
    }

    public void delete(Course course) {
        CourseDB.courses.removeIf(c -> c.getId().equals(course.getId()));
    }

    public Course save(Course course) {
        course.setId(nextId());
        CourseDB.courses.add(course);
        return course;
    }

    public Course update(Integer id, UpsertCourseRequest request) {
        Optional<Course> courseOptional = findById(id);
        if(courseOptional.isPresent()) {
            Course course = courseOptional.get();
            int index = CourseDB.courses.indexOf(course);

            course.setName(request.getName());
            course.setDescription(request.getDescription());
            course.setType(request.getType());
            course.setTopics(request.getTopics());
            course.setThumbnail(request.getThumbnail());
            course.setUserId(request.getUserId());

            CourseDB.courses.set(index, course);
            return course;
        }

        throw new NotFoundException("Not found course");
    }
}
