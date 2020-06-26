package com.ironhack.MidTermProject.model.entities.Accounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentCheckingAccountTest {

    StudentCheckingAccount studentCheckingAccount;

    @BeforeEach
    void setUp() {
        studentCheckingAccount = new StudentCheckingAccount(null, null, null, null);
    }

    @Test
    void getId() {
        studentCheckingAccount.setId((long) 1);
        assertEquals(1, studentCheckingAccount.getId());
    }

    @Test
    void setId() {
        studentCheckingAccount.setId((long) 1);
        assertEquals(1, studentCheckingAccount.getId());
    }

    @Test
    void testHashCode() {
        StudentCheckingAccount sut = new StudentCheckingAccount(null, null, null, null);
        assertEquals(sut.hashCode(), studentCheckingAccount.hashCode());
    }

    @Test
    void testToString() {
        StudentCheckingAccount sut = new StudentCheckingAccount(null, null, null, null);
        assertEquals(sut.toString(), studentCheckingAccount.toString());
    }
}