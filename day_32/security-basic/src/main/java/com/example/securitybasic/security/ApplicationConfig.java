package com.example.securitybasic.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationConfig {
    // 1. Tạo danh sách user
    private final List<UserDetails> userDetailsList = new ArrayList<>(List.of(
            new User("user1", "$2a$10$pAol/CgCIEp9tGbVNDZweeqQgIDI/gOHi65Qkjl7d6s8LsZ4lVUlO", List.of(new SimpleGrantedAuthority("ROLE_USER"))),
            new User("user2", "$2a$10$pAol/CgCIEp9tGbVNDZweeqQgIDI/gOHi65Qkjl7d6s8LsZ4lVUlO", List.of(new SimpleGrantedAuthority("ROLE_USER"),
                    new SimpleGrantedAuthority("ROLE_ADMIN")))
    ));

    // Tạo đối tượng mã hóa
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Tạo đối tượng UserDetailsService để tìm kiếm user
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userDetailsList.stream()
                        .filter(userDetails -> userDetails.getUsername().equals(username))
                        .findFirst()
                        .orElseThrow(() -> {
                            throw new UsernameNotFoundException("Not found user with username = " + username);
                        });
            }
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
