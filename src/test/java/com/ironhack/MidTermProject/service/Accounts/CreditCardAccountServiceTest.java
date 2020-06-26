package com.ironhack.MidTermProject.service.Accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.classes.Address;
import com.ironhack.MidTermProject.model.classes.Money;
import com.ironhack.MidTermProject.model.entities.Accounts.CreditCardAccount;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.service.Users.AccountHolderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class CreditCardAccountServiceTest {
    @MockBean
    CreditCardAccountService creditCardAccountService;

    @MockBean
    AccountHolderService accountHolderService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    public MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    AccountHolder accountHolder;
    CreditCardAccount creditCardAccount;
    List<CreditCardAccount> accounts;

    @BeforeEach
    void setUp() {
        accountHolder = new AccountHolder("jorge", "banana", LocalDate.of(1994, 12, 10), new Address("fake123", "springfield", "usa", 9999), null);
        creditCardAccount = new CreditCardAccount(new Money(new BigDecimal(100)), "yes", accountHolder, null, null, null);
        accounts = Arrays.asList(creditCardAccount);
        when(creditCardAccountService.createCreditCardAccount(creditCardAccount)).thenReturn(creditCardAccount);
        when(creditCardAccountService.getAll()).thenReturn(accounts);
        when(creditCardAccountService.findById(creditCardAccount.getId())).thenReturn(creditCardAccount);
    }

    @Test
    void createCreditCardAccount() {
        assertEquals(creditCardAccount, creditCardAccountService.createCreditCardAccount(creditCardAccount));
    }

    @Test
    void getAll() {
        assertEquals(1, creditCardAccountService.getAll().size());
    }

    @Test
    void findById() {
        assertEquals(creditCardAccount, creditCardAccountService.findById(creditCardAccount.getId()));
    }

    @Test
    void deleteById() {
        creditCardAccountService.deleteById(creditCardAccount.getId());
    }
}