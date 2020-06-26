package com.ironhack.MidTermProject.model.classes;

import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.model.enums.AccountStatus;
import com.ironhack.MidTermProject.model.enums.AccountType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AccountTest {

    AccountTestInstance accountTestInstance;

    @BeforeEach
    void setUp() {
        accountTestInstance = new AccountTestInstance();
    }

    @Test
    void getId() {
        accountTestInstance.setId((long) 1);
        assertEquals(1, accountTestInstance.getId());
    }

    @Test
    void setId() {
        accountTestInstance.setId((long) 1);
        assertEquals(1, accountTestInstance.getId());
    }

    @Test
    void getBalance() {
        accountTestInstance.setBalance(new Money(new BigDecimal(100)));
        assertEquals("US$ 100.00", accountTestInstance.getBalance().toString());
    }

    @Test
    void setBalance() {
        accountTestInstance.setBalance(new Money(new BigDecimal(100)));
        assertEquals("US$ 100.00", accountTestInstance.getBalance().toString());
    }

    @Test
    void getSecretKey() {
        accountTestInstance.setSecretKey("hello");
        assertEquals("hello", accountTestInstance.getSecretKey());
    }

    @Test
    void setSecretKey() {
        accountTestInstance.setSecretKey("hello");
        assertEquals("hello", accountTestInstance.getSecretKey());
    }

    @Test
    void getPrimaryOwner() {
        AccountHolder accountHolder = new AccountHolder(null, null, null, null, null);
        accountTestInstance.setPrimaryOwner(accountHolder);
        assertEquals(accountHolder, accountTestInstance.getPrimaryOwner());
    }

    @Test
    void setPrimaryOwner() {
        AccountHolder accountHolder = new AccountHolder(null, null, null, null, null);
        accountTestInstance.setPrimaryOwner(accountHolder);
        assertEquals(accountHolder, accountTestInstance.getPrimaryOwner());
    }

    @Test
    void getSecondaryOwner() {
        AccountHolder accountHolder = new AccountHolder(null, null, null, null, null);
        accountTestInstance.setSecondaryOwner(accountHolder);
        assertEquals(accountHolder, accountTestInstance.getSecondaryOwner());
    }

    @Test
    void setSecondaryOwner() {
        AccountHolder accountHolder = new AccountHolder(null, null, null, null, null);
        accountTestInstance.setSecondaryOwner(accountHolder);
        assertEquals(accountHolder, accountTestInstance.getSecondaryOwner());
    }

    @Test
    void getPenaltyFee() {
        assertEquals(new BigDecimal(40), accountTestInstance.getPenaltyFee());
    }

    @Test
    void getAccountType() {
        accountTestInstance.setAccountType(AccountType.CREDIT_CARD_ACCOUNT);
        assertEquals(AccountType.CREDIT_CARD_ACCOUNT, accountTestInstance.getAccountType());
    }

    @Test
    void setAccountType() {
        accountTestInstance.setAccountType(AccountType.CREDIT_CARD_ACCOUNT);
        assertEquals(AccountType.CREDIT_CARD_ACCOUNT, accountTestInstance.getAccountType());
    }

    @Test
    void getCreatedAt() {
        accountTestInstance.setCreatedAt(LocalDate.now());
        assertEquals(LocalDate.now(), accountTestInstance.getCreatedAt());
    }

    @Test
    void setCreatedAt() {
        accountTestInstance.setCreatedAt(LocalDate.now());
        assertEquals(LocalDate.now(), accountTestInstance.getCreatedAt());
    }

    @Test
    void getUpdatedAt() {
        accountTestInstance.setUpdatedAt(LocalDate.now());
        assertEquals(LocalDate.now(), accountTestInstance.getUpdatedAt());
    }

    @Test
    void setUpdatedAt() {
        accountTestInstance.setUpdatedAt(LocalDate.now());
        assertEquals(LocalDate.now(), accountTestInstance.getUpdatedAt());
    }

    @Test
    void getStatus() {
        accountTestInstance.setStatus(AccountStatus.FROZEN);
        assertEquals(AccountStatus.FROZEN, accountTestInstance.getStatus());
    }

    @Test
    void setStatus() {
        accountTestInstance.setStatus(AccountStatus.FROZEN);
        assertEquals(AccountStatus.FROZEN, accountTestInstance.getStatus());
    }

    @Test
    void getMaxTransactions24Hrs() {
        accountTestInstance.setMaxTransactions24Hrs(10);
        assertEquals(10, accountTestInstance.getMaxTransactions24Hrs());
    }

    @Test
    void setMaxTransactions24Hrs() {
        accountTestInstance.setMaxTransactions24Hrs(10);
        assertEquals(10, accountTestInstance.getMaxTransactions24Hrs());
    }

    @Test
    void getMaxTransactionsToday() {
        accountTestInstance.setMaxTransactionsToday(10);
        assertEquals(10, accountTestInstance.getMaxTransactionsToday());
    }

    @Test
    void setMaxTransactionsToday() {
        accountTestInstance.setMaxTransactionsToday(10);
        assertEquals(10, accountTestInstance.getMaxTransactionsToday());
    }

    @Test
    void testEquals() {
        AccountTestInstance sut = new AccountTestInstance();
        assertTrue(sut.toString().equals(accountTestInstance.toString()));
    }

    @Test
    void testHashCode() {
        assertEquals(accountTestInstance.hashCode(), accountTestInstance.hashCode());
    }

    @Test
    void testToString() {
        AccountTestInstance sut = new AccountTestInstance();
        assertEquals(sut.toString(), accountTestInstance.toString());
    }

    public class AccountTestInstance extends Account {}
}