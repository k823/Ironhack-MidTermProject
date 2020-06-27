package com.ironhack.MidTermProject.controller.impl.Users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.classes.Address;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.service.Users.AccountHolderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AccountHolderControllerImplTest {

    @MockBean
    AccountHolderService accountHolderService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    AccountHolder accountHolder;
    List<AccountHolder> accountHolders;

    @BeforeEach
    void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        accountHolder = new AccountHolder("account", "holder", LocalDate.of(1993, 1, 1), new Address("fake", "springfield", "usa", 123), null);
        accountHolders = Arrays.asList(accountHolder);

        when(accountHolderService.createAccountHolder(accountHolder)).thenReturn(accountHolder);
        when(accountHolderService.getAll()).thenReturn(accountHolders);
        when(accountHolderService.findById(accountHolder.getId())).thenReturn(accountHolder);
    }


    @Test
    void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/account-holder/find/all"))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/account-holder/find/1"))
                .andExpect(status().isOk());
    }

    @Test
    void createAccountHolder() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/account-holder/new")
                .header("Authorization", "am9yZ2U6YmFuYW5h")
                .content(objectMapper.writeValueAsString(accountHolder))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/account-holder/delete/1"))
                .andExpect(status().isNoContent());
    }
}