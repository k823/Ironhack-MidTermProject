package com.ironhack.MidTermProject.handler;

import com.ironhack.MidTermProject.exception.DataNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class GlobalHandlerTest {

    GlobalHandler globalHandler = new GlobalHandler();

    @Test
    void handleOpportunityIdNotFoundException() {
        assertThrows(Exception.class, () ->  globalHandler.handleOpportunityIdNotFoundException(new DataNotFoundException("Not found."), null));
    }
}