package com.ironhack.MidTermProject.model.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MoneyTest {

    Money money1;
    Money money2;
    Money money;

    @BeforeEach
    void setUp() {
        money1 = new Money();
        money2 = new Money(new BigDecimal(100), Currency.getInstance("USD"));
        money = new Money(new BigDecimal(100));
    }

    @Test
    void increaseAmount() {
        assertEquals(new BigDecimal(101), money.increaseAmount(new BigDecimal(1)).setScale(0));
        assertEquals(new BigDecimal(101), money2.increaseAmount(new Money(new BigDecimal(1))).setScale(0));
    }


    @Test
    void decreaseAmount() {
        assertEquals(new BigDecimal(99), money.decreaseAmount(new BigDecimal(1)).setScale(0));
        assertEquals(new BigDecimal(99), money2.decreaseAmount(new Money(new BigDecimal(1))).setScale(0));

    }

    @Test
    void getCurrency() {
        assertEquals("USD", money.getCurrency().toString());
    }

    @Test
    void getAmount() {
        assertEquals(new BigDecimal(100), money.getAmount().setScale(0));
    }

    @Test
    void testToString() {
        Money sut = new Money(new BigDecimal(100));
        assertEquals(sut.toString(), money.toString());
    }
}