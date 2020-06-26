package com.ironhack.MidTermProject.model.entities.Accounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CreditCardAccountTest {

    CreditCardAccount creditCardAccount;

    @BeforeEach
    void setUp() {
        creditCardAccount = new CreditCardAccount(null, null, null, null, null, null);
    }

    @Test
    void getId() {
        creditCardAccount.setId((long) 1);
        assertEquals(1, creditCardAccount.getId());
    }

    @Test
    void setId() {
        creditCardAccount.setId((long) 1);
        assertEquals(1, creditCardAccount.getId());
    }

    @Test
    void getCreditLimit() {
        creditCardAccount.setCreditLimit(new BigDecimal(100));
        assertEquals(new BigDecimal(100), creditCardAccount.getCreditLimit().setScale(0));
    }

    @Test
    void setCreditLimit() {
        creditCardAccount.setCreditLimit(new BigDecimal(100));
        assertEquals(new BigDecimal(100), creditCardAccount.getCreditLimit().setScale(0));
    }

    @Test
    void getInterestRate() {
        creditCardAccount.setInterestRate(new BigDecimal(100));
        assertEquals(new BigDecimal(100), creditCardAccount.getInterestRate().setScale(0));
    }

    @Test
    void setInterestRate() {
        creditCardAccount.setInterestRate(new BigDecimal(100));
        assertEquals(new BigDecimal(100), creditCardAccount.getInterestRate().setScale(0));
    }

    @Test
    void testEquals() {
        CreditCardAccount sut = new CreditCardAccount(null, null, null, null, null, null);
        assertEquals(sut, creditCardAccount);
    }

    @Test
    void testHashCode() {
        CreditCardAccount sut = new CreditCardAccount(null, null, null, null, null, null);
        assertEquals(sut.hashCode(), creditCardAccount.hashCode());
    }

    @Test
    void testToString() {
        CreditCardAccount sut = new CreditCardAccount(null, null, null, null, null, null);
        assertEquals(sut.toString(), creditCardAccount.toString());
    }
}