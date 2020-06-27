package com.ironhack.MidTermProject.service.Users;

import com.ironhack.MidTermProject.model.entities.Users.ThirdParty;
import com.ironhack.MidTermProject.repository.Users.ThirdPartyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class ThirdPartyServiceTest {
    @Autowired
    ThirdPartyService thirdPartyService;

    @MockBean
    ThirdPartyRepository thirdPartyRepository;

    ThirdParty thirdParty;
    List<ThirdParty> thirdParties;

    @BeforeEach
    void setUp() {
         thirdParty= new ThirdParty("third", "party", "test");
         thirdParties = Arrays.asList(thirdParty);

        when(thirdPartyRepository.findAll()).thenReturn(thirdParties);
        when(thirdPartyRepository.findById(thirdParty.getId())).thenReturn(java.util.Optional.ofNullable(thirdParty));
        when(thirdPartyRepository.save(thirdParty)).thenReturn(thirdParty);

    }

    @Test
    void getAll() {
        assertEquals(1, thirdPartyService.getAll().size());
    }

    @Test
    void findById() {
        assertEquals(thirdParty, thirdPartyService.findById(thirdParty.getId()));
    }

    @Test
    void createThirdParty() throws Exception {
        assertEquals(thirdParty, thirdPartyService.createThirdParty(thirdParty));
        thirdParty.setName(null);
        assertThrows(Exception.class, () -> thirdPartyService.createThirdParty(thirdParty));
    }

    @Test
    void deleteById() {
        thirdPartyService.deleteById(thirdParty.getId());
    }
}