package com.example.sbsecur.model;

import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private int id;
    private String fullname;
    private String job;
    private String gender;
    private String city;
    private int salary;
    private LocalDate birthday;
    private static final DateTimeFormatter dateFormatter =  DateTimeFormatter.ofPattern("yyyy/MM/dd");
    public void setBirthday(String birthday) {
        this.birthday = LocalDate.parse(birthday, dateFormatter);

    }

    // https://javarevisited.blogspot.com/2016/10/how-to-get-number-of-months-and-years-between-two-dates-in-java.html#axzz7CqJvPnRL
    public int getAge() {
        Period intervalPeriod = Period.between(birthday, LocalDate.now());
        return intervalPeriod.getYears();
    }
}

