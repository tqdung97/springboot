package com.example.courseproject.model;

import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int id;
    @NotBlank
    private String name;
    private String email;
    private String phone;
    private String avatar;

}
