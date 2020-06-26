package com.ironhack.MidTermProject.model.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AccountMoneyTest {

    AccountMoney accountMoney;

    @BeforeEach
    void setUp() {
        accountMoney = new AccountMoney(null, null);
    }

    @Test
    void getAccountId() {
        accountMoney.setAccountId((long) 1);
        assertEquals(1, accountMoney.getAccountId());
    }

    @Test
    void setAccountId() {
        accountMoney.setAccountId((long) 1);
        assertEquals(1, accountMoney.getAccountId());
    }

    @Test
    void getAmount() {
        accountMoney.setAmount(new BigDecimal(100));
        assertEquals(new BigDecimal(100), accountMoney.getAmount().setScale(0));
    }

    @Test
    void setAmount() {
        accountMoney.setAmount(new BigDecimal(100));
        assertEquals(new BigDecimal(100), accountMoney.getAmount().setScale(0));
    }
}