package com.example.demobean.config;

import com.example.demobean.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Random;

@Configuration
public class WebConfig {
    @Bean
    public Random random() {
        return new Random();
    }

    @Bean("user1")
    public User user1() {
        return new User("duy");
    }
}
