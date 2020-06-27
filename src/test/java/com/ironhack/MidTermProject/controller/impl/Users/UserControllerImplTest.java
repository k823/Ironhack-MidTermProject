package com.ironhack.MidTermProject.controller.impl.Users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.classes.User;
import com.ironhack.MidTermProject.model.entities.Users.Admin;
import com.ironhack.MidTermProject.repository.Users.UserRepository;
import com.ironhack.MidTermProject.service.Users.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class UserControllerImplTest {
    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    Admin admin;
    List<User> users;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        admin = new Admin();
        admin.setId((long) 1);
        users = Arrays.asList(admin);

        when(userRepository.findAll()).thenReturn((users));
        when(userRepository.findById(admin.getId())).thenReturn(java.util.Optional.ofNullable(admin));
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/find/all"))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/find/1"))
                .andExpect(status().isOk());
    }
}