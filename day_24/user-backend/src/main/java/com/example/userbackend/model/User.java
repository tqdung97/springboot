package com.example.userbackend.model;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    private String phone;

    private String address;

    private String avatar;

    private String password;
}

// B1 : Thêm dependence
// B2 : Thêm cấu hình db trong file application.properties
// B3 : Sửa tạo model user => entity
// B4 : Chạy lại ứng dụng để kiểm tra xem đã tạo table hay chưa
// B5 : Tạo UserRepository
// B6 : Sửa lại UserService

