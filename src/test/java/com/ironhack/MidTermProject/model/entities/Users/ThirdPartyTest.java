package com.ironhack.MidTermProject.model.entities.Users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ThirdPartyTest {

    ThirdParty thirdParty;

    @BeforeEach
    void setUp() {
        thirdParty = new ThirdParty(null, null, null);
    }

    @Test
    void getId() {
        thirdParty.setId((long) 1);
        assertEquals(1, thirdParty.getId());
    }

    @Test
    void setId() {
        thirdParty.setId((long) 1);
        assertEquals(1, thirdParty.getId());
    }

    @Test
    void getHashedKey() {
        thirdParty.setHashedKey("hash");
        assertEquals("hash", thirdParty.getHashedKey());
    }

    @Test
    void setHashedKey() {
        thirdParty.setHashedKey("hash");
        assertEquals("hash", thirdParty.getHashedKey());
    }

    @Test
    void testEquals() {
        ThirdParty sut = new ThirdParty(null, null, null);
        assertEquals(sut, thirdParty);
    }

    @Test
    void testHashCode() {
        ThirdParty sut = new ThirdParty(null, null, null);
        assertEquals(sut.hashCode(), thirdParty.hashCode());
    }

    @Test
    void testToString() {
        ThirdParty sut = new ThirdParty(null, null, null);
        assertEquals(sut.toString(), thirdParty.toString());
    }
}