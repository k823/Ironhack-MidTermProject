package com.ironhack.MidTermProject.model.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransferenceTest {

    Transference transference;
    Transference transference2;

    @BeforeEach
    void setUp() {
        transference2 = new Transference();
        transference = new Transference(null, null, null, null);
    }

    @Test
    void getSenderId() {
        transference.setSenderId((long) 1);
        assertEquals(1, transference.getSenderId());
    }

    @Test
    void setSenderId() {
        transference.setSenderId((long) 1);
        assertEquals(1, transference.getSenderId());
    }

    @Test
    void getReceiverId() {
        transference.setReceiverId((long) 1);
        assertEquals(1, transference.getReceiverId());
    }

    @Test
    void setReceiverId() {
        transference.setReceiverId((long) 1);
        assertEquals(1, transference.getReceiverId());
    }

    @Test
    void getReceiverName() {
        transference.setReceiverName("will");
        assertEquals("will", transference.getReceiverName());
    }

    @Test
    void setReceiverName() {
        transference.setReceiverName("will");
        assertEquals("will", transference.getReceiverName());
    }

    @Test
    void getAmount() {
        transference.setAmount(new BigDecimal(100));
        assertEquals(new BigDecimal(100), transference.getAmount().setScale(0));
    }

    @Test
    void setAmount() {
        transference.setAmount(new BigDecimal(100));
        assertEquals(new BigDecimal(100), transference.getAmount().setScale(0));
    }
}