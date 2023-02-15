package com.example.miniproject;

import com.example.miniproject.dto.UserDto;
import com.example.miniproject.entity.Todo;
import com.example.miniproject.repository.TodoRepository;
import com.example.miniproject.request.LoginRequest;
import com.example.miniproject.service.ColorService;
import com.example.miniproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;

@SpringBootTest
class MiniProjectApplicationTests {

    @Autowired
    private ColorService colorService;

    @Autowired
    private UserService userService;
    @Autowired
    private TodoRepository todoRepository;

    @Test
    void test_randomRgbColor() {
        String rs = colorService.randomRgbColor();

        assertThat(rs).isNotNull();
//        assertThat(rs).isEqualTo("rgb(11,23,124)");
        assertThat(rs).startsWith("rgb");
    }

    @Test
    void test_login() {
        LoginRequest request = new LoginRequest("bob", "123");

        UserDto userDto = userService.login(request);
        System.out.println(userDto);

        assertThat(userDto).isNotNull();
        assertThat(userDto.getUsername()).isEqualTo("bob");
        assertThat(userDto).isInstanceOf(UserDto.class);
        assertThat(userDto).hasOnlyFields("username", "email", "avatar");
        assertThat(userDto).matches((userDto1 -> userDto1.getEmail().startsWith("bob")));
    }
    @Test
    void save_total() {
        Todo todo = Todo.builder()
                .title("ABC")
                .status(true)
                .build();
        todoRepository.save(todo);
    }

    @Test
    void findByTitleStartingWith_test() {
        List<Todo> todos = todoRepository.findByTitleStartingWith("c");


    }
}
