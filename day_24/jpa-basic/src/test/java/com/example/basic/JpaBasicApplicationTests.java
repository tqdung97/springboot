package com.example.basic;

import com.example.basic.entity.User;
import com.example.basic.repository.UserRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaBasicApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Faker faker;

    @Test
    void save_random_user() {
        for (int i = 0; i < 30; i++) {
            User user = User.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .age(faker.number().numberBetween(15, 40))
                    .build();

            userRepository.save(user);
        }
    }

    @Test
    void sort_user_test() {
        List<User> users = userRepository.findAll(Sort.by("age").descending());
        users.forEach(System.out::println);
    }

    @Test
    void pagination_user_test() {
        Page<User> page = userRepository.findAll(PageRequest.of(0, 10, Sort.by("age").descending()));
        page.getContent().forEach(System.out::println);
    }

    @Test
    @Transactional(rollbackFor = {ArrayIndexOutOfBoundsException.class})
    void transaction_test() {
        userRepository.deleteById(3);

        try {
            throw new ArithmeticException("Có lỗi xảy ra");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void save_user() {
        User user = User.builder()
                .name("Nguyễn Văn A")
                .email("a@gmail.com")
                .age(30)
                .build();

        userRepository.save(user);
    }

    @Test
    void save_mutilple_user() {
        User user = User.builder()
                .name("Nguyễn Văn B")
                .email("b@gmail.com")
                .age(36)
                .build();

        User user1 = User.builder()
                .name("Trần Thị C")
                .email("c@gmail.com")
                .age(16)
                .build();

        User user2 = User.builder()
                .name("Ngô Văn D")
                .email("d@gmail.com")
                .age(24)
                .build();

        userRepository.saveAll(List.of(user, user1, user2));
    }

    @Test
    void update_user() {
        Optional<User> userOptional =  userRepository.findById(1);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName("Nguyễn Văn A Update");
            user.setAge(33);

            userRepository.save(user);
        }
    }

    @Test
    void delete_user() {
        userRepository.deleteById(1);
    }

    @Test
    void findByName_test() {
        List<User> users = userRepository.findByName("Nguyễn Văn B");
        users.forEach(System.out::println);

        List<User> users1 = userRepository.findByNameJPQL("Nguyễn Văn B");
        users1.forEach(System.out::println);

        List<User> users2 = userRepository.findByNameNative("Nguyễn Văn B");
        users2.forEach(System.out::println);
    }

    @Test
    void findByNameContainingIgnoreCase_test() {
        List<User> users = userRepository.findByNameContainingIgnoreCase("Văn");
        users.forEach(System.out::println);
    }

    @Test
    void countByAgeBetween_test() {
        long total = userRepository.countByAgeBetween(18, 28);
        System.out.println(total);
    }

    @Test
    void existsByEmail_test() {
        System.out.println(userRepository.existsByEmail("b@gmail.com"));
        System.out.println(userRepository.existsByEmail("a@gmail.com"));
    }

    @Test
    void updateNameUser_test() {
        userRepository.updateNameUser(2, "Nguyễn Văn B update");
    }

    @Test
    void findByAgeJPQL_test() {
        List<User> users = userRepository.findByAgeJPQL(16);
        users.forEach(System.out::println);
    }
}
