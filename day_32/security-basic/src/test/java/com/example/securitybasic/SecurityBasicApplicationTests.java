package com.example.securitybasic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SecurityBasicApplicationTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void test_encode() {
        System.out.println(passwordEncoder.encode("111"));
    }

}
