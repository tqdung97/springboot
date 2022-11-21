package com.example.courseproject.dto;

import com.example.courseproject.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDetailDTO {
    private Integer id;
    private String name;
    private String description;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private User userDTO;
}
