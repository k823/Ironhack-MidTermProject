package com.ironhack.MidTermProject.model.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CheckingAccountDtoTest {

    CheckingAccountDto checkingAccountDto;

    @BeforeEach
    void setUp() {
        checkingAccountDto = new CheckingAccountDto(null, null, null);
    }

    @Test
    void getAccountHolderId() {
        checkingAccountDto.setAccountHolderId((long) 1);
        assertEquals(1, checkingAccountDto.getAccountHolderId());
    }

    @Test
    void setAccountHolderId() {
        checkingAccountDto.setAccountHolderId((long) 1);
        assertEquals(1, checkingAccountDto.getAccountHolderId());
    }

    @Test
    void getBalance() {
        checkingAccountDto.setBalance(new BigDecimal(100));
        assertEquals(new BigDecimal(100), checkingAccountDto.getBalance().setScale(0));
    }

    @Test
    void setBalance() {
        checkingAccountDto.setBalance(new BigDecimal(100));
        assertEquals(new BigDecimal(100), checkingAccountDto.getBalance().setScale(0));
    }

    @Test
    void getSecretKey() {
        checkingAccountDto.setSecretKey("hello");
        assertEquals("hello", checkingAccountDto.getSecretKey());
    }
}