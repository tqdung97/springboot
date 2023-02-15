package com.example.miniproject.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todo")
@Builder
@ToString
public class Todo {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private boolean status;

    @PrePersist
    public void prePersist(){
        status = false;
    }
}
