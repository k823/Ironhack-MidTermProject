package com.ironhack.MidTermProject.model.entities.Accounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SavingsAccountTest {

    SavingsAccount savingsAccount;

    @BeforeEach
    void setUp() {
        savingsAccount = new SavingsAccount(null, null, null, null, null, null);
    }

    @Test
    void getId() {
        savingsAccount.setId((long) 1);
        assertEquals(1, savingsAccount.getId());
    }

    @Test
    void setId() {
        savingsAccount.setId((long) 1);
        assertEquals(1, savingsAccount.getId());
    }

    @Test
    void getMinimumBalance() {
        savingsAccount.setMinimumBalance(new BigDecimal(100));
        assertEquals(new BigDecimal(100), savingsAccount.getMinimumBalance().setScale(0));
    }

    @Test
    void setMinimumBalance() {
        savingsAccount.setMinimumBalance(new BigDecimal(100));
        assertEquals(new BigDecimal(100), savingsAccount.getMinimumBalance().setScale(0));
    }

    @Test
    void getInterestRate() {
        savingsAccount.setInterestRate(new BigDecimal(100));
        assertEquals(new BigDecimal(100), savingsAccount.getInterestRate().setScale(0));
    }

    @Test
    void setInterestRate() {
        savingsAccount.setInterestRate(new BigDecimal(100));
        assertEquals(new BigDecimal(100), savingsAccount.getInterestRate().setScale(0));
    }

    @Test
    void testEquals() {
        SavingsAccount sut = new SavingsAccount(null, null, null, null, null, null);
        assertEquals(sut, savingsAccount);
    }

    @Test
    void testHashCode() {
        SavingsAccount sut = new SavingsAccount(null, null, null, null, null, null);
        assertEquals(sut.hashCode(), savingsAccount.hashCode());
    }

    @Test
    void testToString() {
        SavingsAccount sut = new SavingsAccount(null, null, null, null, null, null);
        assertEquals(sut.toString(), savingsAccount.toString());
    }
}