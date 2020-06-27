package com.ironhack.MidTermProject.service.Users;

import com.ironhack.MidTermProject.model.entities.Users.Admin;
import com.ironhack.MidTermProject.repository.Users.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @MockBean
    AdminRepository adminRepository;


    Admin admin;
    List<Admin> admins;

    @BeforeEach
    void setUp() {
        admin = new Admin("admin", "admin");
        admins = Arrays.asList(admin);

        when(adminRepository.findAll()).thenReturn(admins);
        when(adminRepository.findById(admin.getId())).thenReturn(java.util.Optional.ofNullable(admin));
        when(adminRepository.save(admin)).thenReturn(admin);

    }

    @Test
    void getAll() {
        assertEquals(1, adminService.getAll().size());
    }

    @Test
    void findById() {
        assertEquals(admin, adminService.findById(admin.getId()));
    }

    @Test
    void createAdmin() throws Exception {
        assertEquals(admin, adminService.createAdmin(admin));
        admin.setName(null);
        assertThrows(Exception.class, () -> adminService.createAdmin(admin));
    }

    @Test
    void deleteById() {
        adminService.deleteById(admin.getId());
    }
}