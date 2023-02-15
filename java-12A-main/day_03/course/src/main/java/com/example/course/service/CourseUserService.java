package com.example.course.service;

import com.example.course.model.Course;
import com.example.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseUserService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> filterCourse(String type, String topic, String name) {
        List<Course> courses = courseRepository.findAll();

        List<Course> result = new ArrayList<>();
        for(Course course : courses){
            if((type == null || course.getType().equals(type))
                    && (name == null || course.getName().equals(name))
                    && (topic == null || course.getTopics().contains(topic)))
                result.add(course);
        }
        return result;
    }
}
