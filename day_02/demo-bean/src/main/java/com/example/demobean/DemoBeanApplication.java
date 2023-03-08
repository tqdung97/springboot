package com.example.demobean;

import com.example.demobean.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Random;

@SpringBootApplication
public class DemoBeanApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoBeanApplication.class, args);

        User user = context.getBean("user", User.class);
        System.out.println(user);

        Random rd = context.getBean(Random.class);
        System.out.println(rd.nextInt(100));
    }

}
