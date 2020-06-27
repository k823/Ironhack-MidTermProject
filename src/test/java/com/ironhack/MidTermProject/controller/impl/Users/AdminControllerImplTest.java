package com.ironhack.MidTermProject.controller.impl.Users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.entities.Users.Admin;
import com.ironhack.MidTermProject.service.Users.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AdminControllerImplTest {
    @MockBean
    AdminService adminService;


    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    Admin admin;
    List<Admin> admins;

    @BeforeEach
    void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        admin = new Admin("admin", "admin");
        admins = Arrays.asList(admin);

        when(adminService.getAll()).thenReturn(admins);
        when(adminService.findById(admin.getId())).thenReturn(admin);
        when(adminService.createAdmin(admin)).thenReturn(admin);
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/admin/find/all"))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/admin/find/1"))
                .andExpect(status().isOk());
    }

    @Test
    void createAdmin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/admin/new")
                .header("Authorization", "am9yZ2U6YmFuYW5h")
                .content(objectMapper.writeValueAsString(admin))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/admin/delete/1"))
                .andExpect(status().isNoContent());
    }
}