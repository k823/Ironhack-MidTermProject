package com.ironhack.MidTermProject.model.entities.Users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminTest {

    Admin admin;

    @BeforeEach
    void setUp() {
        admin = new Admin(null, null);
    }

    @Test
    void getId() {
        admin.setId((long) 1);
        assertEquals(1, admin.getId());
    }

    @Test
    void setId() {
        admin.setId((long) 1);
        assertEquals(1, admin.getId());
    }

    @Test
    void testToString() {
        Admin sut = new Admin(null, null);
        assertEquals(sut.toString(), admin.toString());
    }
}