package com.example.demostream.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private String brand;
    private Integer count;
}
