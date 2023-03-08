package com.example.course.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpsertCourseRequest {
    @NotEmpty(message = "name is required")
    private String name;

    @NotEmpty(message = "description is required")
    @Size(min = 50, message = "description must be more than 50 characters")
    private String description;

    @NotEmpty(message = "type is required")
    private String type;

    private List<String> topics;

    private String thumbnail;

    @NotNull(message = "userId is required")
    private Integer userId;
}
