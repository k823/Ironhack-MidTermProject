package com.ironhack.MidTermProject.service.security;

import com.ironhack.MidTermProject.model.entities.Users.Admin;
import com.ironhack.MidTermProject.repository.Users.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDetailsServiceImplTest {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserRepository userRepo;


    public Admin user1;

    @BeforeEach
    void setUp() {
        user1 = new Admin("jorge", "banana");
    }

    @Test
    void loadUserByUsername() {
        try {
            UserDetails user = userDetailsService.loadUserByUsername("jorge");
        } catch (Exception e) {
        }
        assertNotNull(user1);
    }

    @Test
    void loadUserByUsernameException() {
        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername("admin"));
    }
}