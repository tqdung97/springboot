package com.example.miniproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private Boolean status;

    // Vòng đời Entity : Entity Lifecycle
    @PrePersist // Trước khi lưu
    public void prePersist() {
        status = false;
    }
}

// B1 : Thêm dependence
// B2 : Thêm cấu hình db trong file application.properties
// B3 : Sửa tạo model todo => entity
// B4 : Chạy lại ứng dụng để kiểm tra xem đã tạo table hay chưa
// B5 : Tạo TodoRepository
// B6 : Sửa lại TodoService
