package com.example.securitybasic;

import com.example.securitybasic.entity.User;
import com.example.securitybasic.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SecurityBasicApplicationTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Test
    void test_encode() {
        System.out.println(passwordEncoder.encode("111"));
    }

    @Test
    void save_user() {
        User user = User.builder()
                .name("hien")
                .email("hien@gmail.com")
                .password(passwordEncoder.encode("111"))
                .role("ADMIN")
                .build();

        User user1 = User.builder()
                .name("duy")
                .email("duy@gmail.com")
                .password(passwordEncoder.encode("111"))
                .role("USER")
                .build();

        userRepository.save(user);
        userRepository.save(user1);
    }
}
