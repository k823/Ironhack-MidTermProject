package com.ironhack.MidTermProject.model.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ThirdPartyAccessTest {

    ThirdPartyAccess thirdPartyAccess;

    @BeforeEach
    void setUp() {
        thirdPartyAccess = new ThirdPartyAccess(null, null, null);
    }

    @Test
    void getAccountId() {
        thirdPartyAccess.setAccountId((long) 1);
        assertEquals(1, thirdPartyAccess.getAccountId());
    }

    @Test
    void setAccountId() {
        thirdPartyAccess.setAccountId((long) 1);
        assertEquals(1, thirdPartyAccess.getAccountId());
    }

    @Test
    void getAmount() {
        thirdPartyAccess.setAmount(new BigDecimal(100));
        assertEquals(new BigDecimal(100), thirdPartyAccess.getAmount().setScale(0));
    }

    @Test
    void setAmount() {
        thirdPartyAccess.setAmount(new BigDecimal(100));
        assertEquals(new BigDecimal(100), thirdPartyAccess.getAmount().setScale(0));
    }

    @Test
    void getAccountSecretKey() {
        thirdPartyAccess.setAccountSecretKey("hello");
        assertEquals("hello", thirdPartyAccess.getAccountSecretKey());
    }

    @Test
    void setAccountSecretKey() {
        thirdPartyAccess.setAccountSecretKey("hello");
        assertEquals("hello", thirdPartyAccess.getAccountSecretKey());
    }
}