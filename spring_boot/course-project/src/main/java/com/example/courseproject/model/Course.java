package com.example.courseproject.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    @Size(min = 30,message = "Độ dài lớn hơn 30 kí tự")
    private String description;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private int userId;
}
