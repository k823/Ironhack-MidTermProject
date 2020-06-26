package com.ironhack.MidTermProject.model.entities.Accounts;

import com.ironhack.MidTermProject.model.classes.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CheckingAccountTest {

    CheckingAccount checkingAccount;

    @BeforeEach
    void setUp() {
        checkingAccount = new CheckingAccount(null, null, null, null);
    }

    @Test
    void getId() {
        checkingAccount.setId((long) 1);
        assertEquals(1, checkingAccount.getId());
    }

    @Test
    void setId() {
        checkingAccount.setId((long) 1);
        assertEquals(1, checkingAccount.getId());
    }

    @Test
    void getBalance() {
        checkingAccount.setBalance(new BigDecimal(100));
        assertEquals("US$ 100.00", checkingAccount.getBalance().toString());
    }

    @Test
    void setBalanceBigDecimal() {
        checkingAccount.setBalance(new BigDecimal(100));
        assertEquals("US$ 100.00", checkingAccount.getBalance().toString());
    }

    @Test
    void setBalanceMoney() {
        checkingAccount.setBalance(new Money(new BigDecimal(100)));
        assertEquals("US$ 100.00", checkingAccount.getBalance().toString());
    }

    @Test
    void getMinimumBalance() {
        checkingAccount.setMinimumBalance(new BigDecimal(100));
        assertEquals(new BigDecimal(100), checkingAccount.getMinimumBalance());
    }

    @Test
    void setMinimumBalance() {
        checkingAccount.setMinimumBalance(new BigDecimal(100));
        assertEquals(new BigDecimal(100), checkingAccount.getMinimumBalance());
    }

    @Test
    void getPenaltyFee() {
        assertEquals(new BigDecimal(40), checkingAccount.getPenaltyFee());
    }

    @Test
    void getMonthlyMaintenanceFee() {
        checkingAccount.setMonthlyMaintenanceFee(new BigDecimal(100));
        assertEquals(new BigDecimal(100), checkingAccount.getMonthlyMaintenanceFee().setScale(0));
    }

    @Test
    void setMonthlyMaintenanceFee() {
        checkingAccount.setMonthlyMaintenanceFee(new BigDecimal(100));
        assertEquals(new BigDecimal(100), checkingAccount.getMonthlyMaintenanceFee().setScale(0));
    }

    @Test
    void testEquals() {
        CheckingAccount sut = new CheckingAccount(null, null, null, null);
        assertEquals(sut, checkingAccount);
    }

    @Test
    void testHashCode() {
        CheckingAccount sut = new CheckingAccount(null, null, null, null);
        assertEquals(sut.hashCode(), checkingAccount.hashCode());
    }

    @Test
    void testToString() {
        CheckingAccount sut = new CheckingAccount(null, null, null, null);
        assertEquals(sut.toString(), checkingAccount.toString());
    }
}