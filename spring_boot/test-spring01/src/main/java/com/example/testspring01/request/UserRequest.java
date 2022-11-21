package com.example.testspring01.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {

    private String name;
    private String email;
    private String address;
    private String phone;
    private String avatar;
}
