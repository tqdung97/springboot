package com.example.securitybasic;

import com.example.securitybasic.entity.User;
import com.example.securitybasic.repository.UserRepository;
import com.example.securitybasic.security.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootTest
class SecurityBasicApplicationTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

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

    @Test
    void generate_token_test() {
        Optional<User> userOptional = userRepository.findByEmail("hien@gmail.com");
        if(userOptional.isPresent()) {
            String token = jwtTokenUtil.generateToken(userOptional.get());
            System.out.println(token);
        }
    }

    @Test
    void parse_token_test() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9XSwic3ViIjoiaGllbkBnbWFpbC5jb20iLCJpYXQiOjE2NzcwODA2NTUsImV4cCI6MTY3NzE2NzA1NX0.9CMhTCKQKTuwSmpoCThSM2JhXZGvHnBBOrXHFKUYAnQ";
        Claims claims = jwtTokenUtil.getClaimsFromToken(token);
        System.out.println(claims.getSubject());
    }
}
