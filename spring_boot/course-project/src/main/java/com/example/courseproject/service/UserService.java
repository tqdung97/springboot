package com.example.courseproject.service;

import com.example.courseproject.dto.CourseDetailDTO;
import com.example.courseproject.exception.NotFoundException;
import com.example.courseproject.model.Course;
import com.example.courseproject.model.User;
import com.example.courseproject.repository.CourseRepository;
import com.example.courseproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public List<Course> findAll(String nameValue, String typeValue, String topicValue){
        List<Course> courses = courseRepository.findAll();
        List<Course> result = List.copyOf(courses);
         if (typeValue == null && nameValue == null && topicValue == null) {
             return courses;
         }else {
             if(nameValue != null){
                 result = result.stream().filter(course ->course.getName().contains(nameValue)).toList();
             }
             if(typeValue != null){
                 result = result.stream().filter(n->n.getType().contains(typeValue)).toList();
             }
             if(topicValue != null){
                 result = result.stream().filter(course -> course.getTopics().contains(topicValue)).toList();
             }
         }
         return result;
    }

    public CourseDetailDTO findById(Integer id){
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("This id is not existed, id= " + id));
        User user = userRepository.findById(course.getUserId())
                .orElseThrow(() -> new NotFoundException("This id is not existed, id= " + id));
        return new CourseDetailDTO(
                course.getId(),
                course.getName(),
                course.getDescription(),
                course.getType(),
                course.getTopics(),
                course.getThumbnail(),
                user);

    }

}
