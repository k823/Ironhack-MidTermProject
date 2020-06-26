package com.ironhack.MidTermProject.model.entities.Transferences;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TransferenceRegistryTest {

    TransferenceRegistry transferenceRegistry;

    @BeforeEach
    void setUp() {
        transferenceRegistry = new TransferenceRegistry(null, null, null, null, null, null, null);
    }

    @Test
    void getId() {
        transferenceRegistry.setId((long) 1);
        assertEquals(1, transferenceRegistry.getId());
    }

    @Test
    void setId() {
        transferenceRegistry.setId((long) 1);
        assertEquals(1, transferenceRegistry.getId());
    }

    @Test
    void getSenderAccountId() {
        transferenceRegistry.setSenderAccountId((long) 1);
        assertEquals(1, transferenceRegistry.getSenderAccountId());
    }

    @Test
    void setSenderAccountId() {
        transferenceRegistry.setSenderAccountId((long) 1);
        assertEquals(1, transferenceRegistry.getSenderAccountId());
    }

    @Test
    void getSenderAccountName() {
        transferenceRegistry.setSenderAccountName("true");
        assertEquals("true", transferenceRegistry.getSenderAccountName());
    }

    @Test
    void setSenderAccountName() {
        transferenceRegistry.setSenderAccountName("true");
        assertEquals("true", transferenceRegistry.getSenderAccountName());
    }

    @Test
    void getSenderAccountBalance() {
        transferenceRegistry.setSenderAccountBalance(new BigDecimal(100));
        assertEquals(new BigDecimal(100), transferenceRegistry.getSenderAccountBalance().setScale(0));
    }

    @Test
    void setSenderAccountBalance() {
        transferenceRegistry.setSenderAccountBalance(new BigDecimal(100));
        assertEquals(new BigDecimal(100), transferenceRegistry.getSenderAccountBalance().setScale(0));
    }

    @Test
    void getReceiverAccountId() {
        transferenceRegistry.setReceiverAccountId((long) 1);
        assertEquals(1, transferenceRegistry.getReceiverAccountId());
    }

    @Test
    void setReceiverAccountId() {
        transferenceRegistry.setReceiverAccountId((long) 1);
        assertEquals(1, transferenceRegistry.getReceiverAccountId());
    }

    @Test
    void getReceiverAccountName() {
        transferenceRegistry.setReceiverAccountName("true");
        assertEquals("true", transferenceRegistry.getReceiverAccountName());
    }

    @Test
    void setReceiverAccountName() {
        transferenceRegistry.setReceiverAccountName("true");
        assertEquals("true", transferenceRegistry.getReceiverAccountName());
    }

    @Test
    void getReceiverAccountBalance() {
        transferenceRegistry.setReceiverAccountBalance(new BigDecimal(100));
        assertEquals(new BigDecimal(100), transferenceRegistry.getReceiverAccountBalance().setScale(0));
    }

    @Test
    void setReceiverAccountBalance() {
        transferenceRegistry.setReceiverAccountBalance(new BigDecimal(100));
        assertEquals(new BigDecimal(100), transferenceRegistry.getReceiverAccountBalance().setScale(0));
    }

    @Test
    void getAmount() {
        transferenceRegistry.setAmount(new BigDecimal(100));
        assertEquals(new BigDecimal(100), transferenceRegistry.getAmount());
    }

    @Test
    void setAmount() {
        transferenceRegistry.setAmount(new BigDecimal(100));
        assertEquals(new BigDecimal(100), transferenceRegistry.getAmount());
    }

    @Test
    void getDate() {
        transferenceRegistry.setDate(LocalDate.now());
        assertEquals(LocalDate.now(), transferenceRegistry.getDate());
    }

    @Test
    void setDate() {
        transferenceRegistry.setDate(LocalDate.now());
        assertEquals(LocalDate.now(), transferenceRegistry.getDate());
    }

    @Test
    void getTime() {
        transferenceRegistry.setTime(LocalTime.now());
        assertEquals(LocalTime.now().getHour(), transferenceRegistry.getTime().getHour());
    }

    @Test
    void setTime() {
        transferenceRegistry.setTime(LocalTime.now());
        assertEquals(LocalTime.now().getHour(), transferenceRegistry.getTime().getHour());
    }

    @Test
    void testToString() {
        TransferenceRegistry sut = new TransferenceRegistry(null, null, null, null, null, null, null);
        assertEquals(sut.toString().substring(0, 10), transferenceRegistry.toString().substring(0, 10));
    }
}