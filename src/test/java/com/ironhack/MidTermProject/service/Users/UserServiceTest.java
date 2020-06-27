package com.ironhack.MidTermProject.service.Users;

import com.ironhack.MidTermProject.model.classes.User;
import com.ironhack.MidTermProject.model.entities.Users.Admin;
import com.ironhack.MidTermProject.repository.Users.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;


    Admin admin;
    List<User> users;

    @BeforeEach
    void setUp() {
        admin = new Admin();
        users = Arrays.asList(admin);

        when(userRepository.findAll()).thenReturn((users));
        when(userRepository.findById(admin.getId())).thenReturn(java.util.Optional.ofNullable(admin));
    }

    @Test
    void getAll() {
        assertEquals(1, userService.getAll().size());
    }

    @Test
    void findById() {
        assertEquals(admin, userService.findById(admin.getId()));
    }
}