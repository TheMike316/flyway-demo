package com.example.flywaydemo.bootstrap;

import com.example.flywaydemo.domain.Todo;
import com.example.flywaydemo.domain.User;
import com.example.flywaydemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataBootstrap implements InitializingBean {

    private final UserRepository userRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
//        if (userRepository.count() == 0) {
        var users = createUsers();
        userRepository.saveAll(users);
//        }
    }

    private List<User> createUsers() {
        var user1 = User.builder()
                .username("username1")
                .password("not a real password anyways")
                .todos(createRandomTodos())
                .build();
        var user2 = User.builder()
                .username("username2")
                .password("not a real password anyways")
                .todos(createRandomTodos())
                .build();

        return Arrays.asList(user1, user2);
    }

    private List<Todo> createRandomTodos() {
        return Arrays.asList(
                Todo.builder()
                        .title("Todo 1")
                        .description("do this")
                        .build(),
                Todo.builder()
                        .title("Todo 2")
                        .description("do that")
                        .build(),
                Todo.builder()
                        .title("Todo 3")
                        .description("do more of this")
                        .build()
        );
    }
}
