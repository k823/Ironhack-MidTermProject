package com.ironhack.MidTermProject.controller.impl.Accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.classes.Address;
import com.ironhack.MidTermProject.model.classes.Money;
import com.ironhack.MidTermProject.model.entities.Accounts.CheckingAccount;
import com.ironhack.MidTermProject.model.entities.Accounts.StudentCheckingAccount;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.repository.Accounts.StudentCheckingAccountRepository;
import com.ironhack.MidTermProject.repository.Users.AccountHolderRepository;
import com.ironhack.MidTermProject.service.Accounts.CheckingAccountService;
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
class CheckingAccountControllerImplTest {

    @MockBean
    CheckingAccountService checkingAccountService;

    @MockBean
    StudentCheckingAccountRepository studentCheckingAccountRepository;

    @MockBean
    AccountHolderRepository accountHolderRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    public MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    AccountHolder accountHolder;
    CheckingAccount checkingAccount;
    StudentCheckingAccount studentCheckingAccount;
    List<CheckingAccount> accounts;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        accountHolder = new AccountHolder("jorge", "banana", LocalDate.of(1994, 12, 10), new Address("fake123", "springfield", "usa", 9999), null);
        checkingAccount = new CheckingAccount(new Money(new BigDecimal(100)), "yes", accountHolder, null);
        checkingAccount.setCreatedAt(LocalDate.now());
        studentCheckingAccount = new StudentCheckingAccount(new Money(new BigDecimal(100)), "yes", accountHolder, null);
        accounts = Arrays.asList(checkingAccount);
        when(checkingAccountService.createCheckingAccount(checkingAccount)).thenReturn(checkingAccount);
        when(studentCheckingAccountRepository.save(studentCheckingAccount)).thenReturn(studentCheckingAccount);
        when(checkingAccountService.getAll()).thenReturn(accounts);
        when(checkingAccountService.findById(checkingAccount.getId())).thenReturn(checkingAccount);
        when(accountHolderRepository.findById(checkingAccount.getId())).thenReturn(java.util.Optional.ofNullable(accountHolder));
    }

//    @Test
//    void createCheckingAccount() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/accounts/checking/new")
//                .header("Authorization", "am9yZ2U6YmFuYW5h")
//                .content(objectMapper.writeValueAsString(checkingAccount))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated());
//    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/checking/find/all"))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/checking/find/1"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/accounts/checking/delete/1"))
                .andExpect(status().isNoContent());
    }
}