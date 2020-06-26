package com.ironhack.MidTermProject.model.enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AccountStatusTest {

    AccountStatus active;
    AccountStatus frozen;

    @BeforeEach
    void setUp() {
        active = AccountStatus.ACTIVE;
        frozen = AccountStatus.FROZEN;
    }

    @Test
    void getDescription() {
        assertEquals(active.getDescription(), AccountStatus.ACTIVE.getDescription());
        assertEquals(frozen.getDescription(), AccountStatus.FROZEN.getDescription());
    }

    @Test
    void setDescription() {
        active.setDescription("hello");
        assertEquals("hello", active.getDescription());
        frozen.setDescription("hello");
        assertEquals("hello", frozen.getDescription());
    }

    @Test
    void values() {
        assertEquals(2, AccountStatus.values().length);
    }

    @Test
    void valueOf() {
        assertEquals(active, AccountStatus.valueOf("ACTIVE"));
        assertEquals(frozen, AccountStatus.valueOf("FROZEN"));
    }
}