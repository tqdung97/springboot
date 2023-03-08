package com.example.demostream.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateProductRequest {
    private String name;
    private Integer price;
    private String brand;
    private Integer count;
}
