package com.ironhack.MidTermProject.model.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressTest {

    Address address;

    @BeforeEach
    void setUp() {
        address = new Address();
        address = new Address(null, null, null, null);
    }

    @Test
    void getStreet() {
        address.setStreet("true");
        assertEquals("true", address.getStreet());
    }

    @Test
    void setStreet() {
        address.setStreet("true");
        assertEquals("true", address.getStreet());
    }

    @Test
    void getCity() {
        address.setCity("true");
        assertEquals("true", address.getCity());
    }

    @Test
    void setCity() {
        address.setCity("true");
        assertEquals("true", address.getCity());
    }

    @Test
    void getCountry() {
        address.setCountry("true");
        assertEquals("true", address.getCountry());
    }

    @Test
    void setCountry() {
        address.setCountry("true");
        assertEquals("true", address.getCountry());
    }

    @Test
    void getPostalCode() {
        address.setPostalCode(1234);
        assertEquals(1234, address.getPostalCode());
    }

    @Test
    void setPostalCode() {
        address.setPostalCode(1234);
        assertEquals(1234, address.getPostalCode());
    }

    @Test
    void testEquals() {
        Address sut = new Address(null, null, null, null);
        assertEquals(sut, address);
    }

    @Test
    void testHashCode() {
        Address sut = new Address(null, null, null, null);
        assertEquals(sut.hashCode(), address.hashCode());
    }

    @Test
    void testToString() {
        Address sut = new Address(null, null, null, null);
        assertEquals(sut.toString(), address.toString());
    }
}