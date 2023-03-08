package com.example.basic;

import com.example.basic.dto.UserDto;
import com.example.basic.dto.UserInfo;
import com.example.basic.dto.UserMapper;
import com.example.basic.entity.User;
import com.example.basic.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByEmailContainingIgnoreCase_test() {
        List<UserDto> userDtoList = userRepository.findByEmailContainingIgnoreCase("hi");
        userDtoList.forEach(System.out::println);
    }

    @Test
    void findByNameStartingWith_test() {
        List<User> users = userRepository.findByNameStartingWith("c");
        List<UserDto> userDtoList = users.stream()
                .map(user -> UserMapper.toUserDto(user))
                .toList();
        userDtoList.forEach(System.out::println);
    }

    @Test
    void findAllUserDto_test() {
        List<UserDto> userDtoList = userRepository.findAllUserDto();
        userDtoList.forEach(System.out::println);
    }

    @Test
    void findUserInfoByNameStartingWith_test() {
        List<UserInfo> userInfos = userRepository.findUserInfoByNameStartingWith("c");
        userInfos.forEach(userInfo -> System.out.println(userInfo.getId() + " - " + userInfo.getName() + " - " + userInfo.getEmail()));
    }
}
