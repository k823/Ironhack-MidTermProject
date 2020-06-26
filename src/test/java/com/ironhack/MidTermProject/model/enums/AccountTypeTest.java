package com.ironhack.MidTermProject.model.enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountTypeTest {

    AccountType checkingAccount;
    AccountType creditCardAccount;
    AccountType savingsAccount;
    AccountType studentCheckingAccount;

    @BeforeEach
    void setUp() {
        checkingAccount = AccountType.CHECKING_ACCOUNT;
        creditCardAccount = AccountType.CREDIT_CARD_ACCOUNT;
        savingsAccount = AccountType.SAVINGS_ACCOUNT;
        studentCheckingAccount = AccountType.STUDENT_CHECKING_ACCOUNT;
    }

    @Test
    void getDescription() {
        assertEquals(checkingAccount.getDescription(), AccountType.CHECKING_ACCOUNT.getDescription());
        assertEquals(creditCardAccount.getDescription(), AccountType.CREDIT_CARD_ACCOUNT.getDescription());
        assertEquals(savingsAccount.getDescription(), AccountType.SAVINGS_ACCOUNT.getDescription());
        assertEquals(studentCheckingAccount.getDescription(), AccountType.STUDENT_CHECKING_ACCOUNT.getDescription());
    }

    @Test
    void setDescription() {
       checkingAccount.setDescription("hello");
       assertEquals("hello", checkingAccount.getDescription());
       creditCardAccount.setDescription("hello");
       assertEquals("hello", creditCardAccount.getDescription());
       savingsAccount.setDescription("hello");
       assertEquals("hello", savingsAccount.getDescription());
       studentCheckingAccount.setDescription("hello");
       assertEquals("hello", studentCheckingAccount.getDescription());
    }

    @Test
    void values() {
        assertEquals(4, AccountType.values().length);
    }

    @Test
    void valueOf() {
        assertEquals(checkingAccount.toString(), "CHECKING_ACCOUNT");
        assertEquals(creditCardAccount.toString(), "CREDIT_CARD_ACCOUNT");
        assertEquals(savingsAccount.toString(), "SAVINGS_ACCOUNT");
        assertEquals(studentCheckingAccount.toString(), "STUDENT_CHECKING_ACCOUNT");
    }
}