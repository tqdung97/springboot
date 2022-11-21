package com.example.testspring01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignup {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
}
