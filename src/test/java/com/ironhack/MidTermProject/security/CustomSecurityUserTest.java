package com.ironhack.MidTermProject.security;

import com.ironhack.MidTermProject.model.entities.Users.Admin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CustomSecurityUserTest {

    private Admin user;
    private CustomSecurityUser customSecurityUser;

    @BeforeEach
    public void setUp(){
        user = new Admin("admin", "admin");
        customSecurityUser = new CustomSecurityUser(user);
    }

    @AfterEach
    public void tearDown(){
        user = null;
        customSecurityUser = null;
    }

    @Test
    public void isAccountNonExpired_customSecurityUser_boolean(){
        assertTrue(customSecurityUser.isAccountNonExpired());
    }

    @Test
    public void setCustomSecurityUser_userRoles_userGerRoles(){
        customSecurityUser.setRole(user.getRole());
        assertEquals(user.getRole(), customSecurityUser.getRole());
    }

    @Test
    public void isAccountNonLocked_customSecurityUser_boolean(){
        assertTrue(customSecurityUser.isAccountNonLocked());
    }

    @Test
    public void isCredentialsNonExpired_customSecurityUser_boolean(){
        assertTrue(customSecurityUser.isCredentialsNonExpired());
    }

    @Test
    public void isEnabled_CustomSecurityUser_boolean(){
        assertTrue(customSecurityUser.isEnabled());
    }

    @Test
    void getAuthorities() {
        Collection<? extends GrantedAuthority> result = customSecurityUser.getAuthorities();
        assertEquals(1, result.size());
    }

    @Test
    void getUsername() {
        assertEquals("admin", customSecurityUser.getUsername());
    }
}