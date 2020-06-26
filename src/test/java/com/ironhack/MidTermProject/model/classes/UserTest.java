package com.ironhack.MidTermProject.model.classes;

import com.ironhack.MidTermProject.model.enums.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    UserTestInstance userTestInstance;

    @BeforeEach
    void setUp() {
        userTestInstance = new UserTestInstance();
    }

    @Test
    void getName() {
        userTestInstance.setName("hello");
        assertEquals("hello", userTestInstance.getName());
    }

    @Test
    void setName() {
        userTestInstance.setName("hello");
        assertEquals("hello", userTestInstance.getName());
    }

    @Test
    void getId() {
        userTestInstance.setId((long) 1);
        assertEquals(1, userTestInstance.getId());
    }

    @Test
    void setId() {
        userTestInstance.setId((long) 1);
        assertEquals(1, userTestInstance.getId());
    }

    @Test
    void getRole() {
        userTestInstance.setRole(UserType.ADMIN);
        assertEquals(UserType.ADMIN, userTestInstance.getRole());
    }

    @Test
    void setRole() {
        userTestInstance.setRole(UserType.ADMIN);
        assertEquals(UserType.ADMIN, userTestInstance.getRole());
    }

    @Test
    void getPassword() {
        userTestInstance.setPassword("hello");
        assertEquals("hello", userTestInstance.getPassword());
    }

    @Test
    void setPassword() {
        userTestInstance.setPassword("hello");
        assertEquals("hello", userTestInstance.getPassword());
    }

    @Test
    void testEquals() {
        UserTestInstance sut = new UserTestInstance();
        assertTrue(userTestInstance.toString().equals(sut.toString()));
    }

    @Test
    void testHashCode() {
        UserTestInstance sut = new UserTestInstance();
        assertEquals(sut.hashCode(), userTestInstance.hashCode());
    }

    @Test
    void testToString() {
        UserTestInstance sut = new UserTestInstance();
        assertEquals(sut.toString(), userTestInstance.toString());
    }

    public class UserTestInstance extends User {}
}