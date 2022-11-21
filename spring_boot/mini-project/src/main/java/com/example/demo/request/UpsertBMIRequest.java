package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class UpsertBMIRequest {
    @NotBlank(message = "Username is required")
    private double height;
    @NotBlank(message = "Password is required")
    @Min(value = 4, message = "Length password")
    private double weight;

}
