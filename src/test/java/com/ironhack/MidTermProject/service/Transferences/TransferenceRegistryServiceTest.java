package com.ironhack.MidTermProject.service.Transferences;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.entities.Transferences.TransferenceRegistry;
import com.ironhack.MidTermProject.repository.Transferences.TransferenceRegistryRepository;
import com.ironhack.MidTermProject.service.Users.AccountHolderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class TransferenceRegistryServiceTest {

    @Autowired
    TransferenceRegistryService transferenceRegistryService;

    @MockBean
    TransferenceRegistryRepository transferenceRegistryRepository;

    @MockBean
    AccountHolderService accountHolderService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    public MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    TransferenceRegistry transferenceRegistry;
    List<TransferenceRegistry> registries;

    @BeforeEach
    void setUp() {
        transferenceRegistry = new TransferenceRegistry(null, null, null, null, null, null, null);
        registries = Arrays.asList(transferenceRegistry);

        when(transferenceRegistryRepository.save(transferenceRegistry)).thenReturn(transferenceRegistry);
        when(transferenceRegistryRepository.findAll()).thenReturn(registries);
        when(transferenceRegistryRepository.findById(transferenceRegistry.getId())).thenReturn(java.util.Optional.ofNullable(transferenceRegistry));
    }

    @Test
    void getAll() {
        assertEquals(1, transferenceRegistryService.getAll().size());
    }

    @Test
    void findById() {
        assertEquals(transferenceRegistry, transferenceRegistryService.findById(transferenceRegistry.getId()));
    }

    @Test
    void createTransferenceRegistry() {
        assertEquals(transferenceRegistry, transferenceRegistryService.createTransferenceRegistry(transferenceRegistry));
    }

    @Test
    void deleteTransferenceRegistryById() {
        transferenceRegistryService.deleteTransferenceRegistryById(transferenceRegistry.getId());
    }
}