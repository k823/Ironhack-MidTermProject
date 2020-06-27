package com.ironhack.MidTermProject.controller.impl.Accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.classes.Address;
import com.ironhack.MidTermProject.model.classes.Money;
import com.ironhack.MidTermProject.model.entities.Accounts.SavingsAccount;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.service.Accounts.SavingsAccountService;
import com.ironhack.MidTermProject.service.Users.AccountHolderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class SavingsAccountControllerImplTest {
    @MockBean
    SavingsAccountService savingsAccountService;

    @MockBean
    AccountHolderService accountHolderService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    public MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    AccountHolder accountHolder;
    SavingsAccount savingsAccount;
    List<SavingsAccount> accounts;

    @BeforeEach
    void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        accountHolder = new AccountHolder("jorge", "banana", LocalDate.of(1994, 12, 10), new Address("fake123", "springfield", "usa", 9999), null);
        savingsAccount = new SavingsAccount(new Money(new BigDecimal(100)), "yes", accountHolder, null, new BigDecimal(300), new BigDecimal(0.1));
        accounts = Arrays.asList(savingsAccount);
        when(savingsAccountService.createSavingsAccount(savingsAccount)).thenReturn(savingsAccount);
        when(savingsAccountService.getAll()).thenReturn(accounts);
        when(savingsAccountService.findById(savingsAccount.getId())).thenReturn(savingsAccount);
        when(accountHolderService.findById(savingsAccount.getId())).thenReturn(accountHolder);
    }
//    @Test
//    void createSavingsAccount() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/accounts/saving/new")
//                .header("Authorization", "am9yZ2U6YmFuYW5h")
//                .content(objectMapper.writeValueAsString(savingsAccount))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated());
//    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/saving/find/all"))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/saving/find/1"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/accounts/saving/delete/1"))
                .andExpect(status().isNoContent());
    }
}