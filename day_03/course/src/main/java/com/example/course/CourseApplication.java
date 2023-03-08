package com.example.course;

import com.example.course.db.CourseDB;
import com.example.course.db.InitData;
import com.example.course.db.UserDB;
import com.github.javafaker.Faker;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseApplication.class, args);
    }

    @Bean
    public Faker faker() {
        return new Faker();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public CommandLineRunner commandLineRunner(InitData initData) {
        return (args) -> {
            UserDB.users = initData.initUsers();
            CourseDB.courses = initData.initCourses(UserDB.users);
        };
    }
}
