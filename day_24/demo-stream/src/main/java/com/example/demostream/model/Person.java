package com.example.demostream.model;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Person {
    private Integer id;
    private String fullName;
    private String job;
    private String gender;
    private String city;
    private Integer salary;
    private LocalDate birthday;

    private static final DateTimeFormatter dateFormatter =  DateTimeFormatter.ofPattern("yyyy/MM/dd");
    public void setBirthday(String birthday) {
        this.birthday = LocalDate.parse(birthday, dateFormatter);

    }
}
