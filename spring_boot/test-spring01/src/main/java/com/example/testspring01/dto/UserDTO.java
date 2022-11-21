package com.example.testspring01.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String avatar;
}
