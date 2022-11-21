package com.example.demo.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpsertBookRequest {
    private String title;
    private String description;
    private int publishYear;

}
