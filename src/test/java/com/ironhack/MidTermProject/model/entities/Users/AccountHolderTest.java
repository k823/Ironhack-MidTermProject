package com.ironhack.MidTermProject.model.entities.Users;

import com.ironhack.MidTermProject.model.classes.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountHolderTest {

    AccountHolder accountHolder;

    @BeforeEach
    void setUp() {
        accountHolder = new AccountHolder(null, null, null, null, null);
    }

    @Test
    void getId() {
        accountHolder.setId((long) 1);
        assertEquals(1, accountHolder.getId());
    }

    @Test
    void setId() {
        accountHolder.setId((long) 1);
        assertEquals(1, accountHolder.getId());
    }

    @Test
    void getBirthDate() {
        accountHolder.setBirthDate(LocalDate.now());
        assertEquals(LocalDate.now(), accountHolder.getBirthDate());
    }

    @Test
    void setBirthDate() {
        accountHolder.setBirthDate(LocalDate.now());
        assertEquals(LocalDate.now(), accountHolder.getBirthDate());
    }

    @Test
    void getPrimaryAddress() {
        Address address = new Address(null, null, null, null);
        accountHolder.setPrimaryAddress(address);
        assertEquals(address, accountHolder.getPrimaryAddress());
    }

    @Test
    void setPrimaryAddress() {
        Address address = new Address(null, null, null, null);
        accountHolder.setPrimaryAddress(address);
        assertEquals(address, accountHolder.getPrimaryAddress());
    }

    @Test
    void getMailingAddress() {
        Address address = new Address(null, null, null, null);
        accountHolder.setMailingAddress(address);
        assertEquals(address, accountHolder.getMailingAddress());
    }

    @Test
    void setMailingAddress() {
        Address address = new Address(null, null, null, null);
        accountHolder.setMailingAddress(address);
        assertEquals(address, accountHolder.getMailingAddress());
    }

    @Test
    void testEquals() {
        AccountHolder sut = new AccountHolder(null, null, null, null, null);
        assertEquals(sut, accountHolder);
    }

    @Test
    void testHashCode() {
        AccountHolder sut = new AccountHolder(null, null, null, null, null);
        assertEquals(sut.hashCode(), accountHolder.hashCode());
    }

    @Test
    void testToString() {
        AccountHolder sut = new AccountHolder(null, null, null, null, null);
        assertEquals(sut.toString(), accountHolder.toString());
    }
}