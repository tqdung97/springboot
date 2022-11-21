package com.example.homework_01.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpsertJobRequest {

        private String title;
        private String description;
        private String location;
        private int minSalary;
        private int maxSalary;
        private String emailTo;
}
