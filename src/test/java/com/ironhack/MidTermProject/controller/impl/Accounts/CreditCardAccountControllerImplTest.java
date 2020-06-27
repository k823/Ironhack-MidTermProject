package com.ironhack.MidTermProject.controller.impl.Accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.classes.Address;
import com.ironhack.MidTermProject.model.classes.Money;
import com.ironhack.MidTermProject.model.entities.Accounts.CreditCardAccount;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.repository.Users.AccountHolderRepository;
import com.ironhack.MidTermProject.service.Accounts.CreditCardAccountService;
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
class CreditCardAccountControllerImplTest {

    @MockBean
    CreditCardAccountService creditCardAccountService;

    @MockBean
    AccountHolderRepository accountHolderRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    public MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    AccountHolder accountHolder;
    CreditCardAccount creditCardAccount;
    List<CreditCardAccount> accounts;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        accountHolder = new AccountHolder("jorge", "banana", LocalDate.of(1994, 12, 10), new Address("fake123", "springfield", "usa", 9999), null);
        creditCardAccount = new CreditCardAccount(new Money(new BigDecimal(100)), "yes", accountHolder, null, new BigDecimal(500), new BigDecimal(0.2));
        accounts = Arrays.asList(creditCardAccount);

        when(creditCardAccountService.createCreditCardAccount(creditCardAccount)).thenReturn(creditCardAccount);
        when(creditCardAccountService.getAll()).thenReturn(accounts);
        when(creditCardAccountService.findById(creditCardAccount.getId())).thenReturn(creditCardAccount);
        when(accountHolderRepository.findById(creditCardAccount.getId())).thenReturn(java.util.Optional.ofNullable(accountHolder));

    }

//    @Test
//    void createCreditCardAccount() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/accounts/credit/new")
//                .header("Authorization", "am9yZ2U6YmFuYW5h")
//                .content(objectMapper.writeValueAsString(creditCardAccount))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated());
//    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/credit/find/all"))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/credit/find/1"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/accounts/credit/delete/1"))
                .andExpect(status().isNoContent());
    }
}