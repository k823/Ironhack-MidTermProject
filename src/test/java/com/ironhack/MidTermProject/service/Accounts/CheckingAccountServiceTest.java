package com.ironhack.MidTermProject.service.Accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.classes.Address;
import com.ironhack.MidTermProject.model.classes.Money;
import com.ironhack.MidTermProject.model.entities.Accounts.CheckingAccount;
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
class CheckingAccountServiceTest {

    @MockBean
    CheckingAccountService checkingAccountService;

    @MockBean
    AccountHolderService accountHolderService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    public MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    AccountHolder accountHolder;
    CheckingAccount checkingAccount;
    List<CheckingAccount> accounts;

    @BeforeEach
    void setUp() {
        accountHolder = new AccountHolder("jorge", "banana", LocalDate.of(1994, 12, 10), new Address("fake123", "springfield", "usa", 9999), null);
        checkingAccount = new CheckingAccount(new Money(new BigDecimal(100)), "yes", accountHolder, null);
        accounts = Arrays.asList(checkingAccount);
        when(checkingAccountService.createCheckingAccount(checkingAccount)).thenReturn(checkingAccount);
        when(checkingAccountService.checkAccountType(checkingAccount)).thenReturn(checkingAccount);
        when(checkingAccountService.getAll()).thenReturn(accounts);
        when(checkingAccountService.findById(checkingAccount.getId())).thenReturn(checkingAccount);
    }

    @Test
    void createCheckingAccount() {
        assertEquals(checkingAccount, checkingAccountService.createCheckingAccount(checkingAccount));
    }

    @Test
    void checkAccountType() {
        assertEquals(checkingAccount, checkingAccountService.checkAccountType(checkingAccount));
    }

    @Test
    void checkAge() {
        checkingAccountService.checkAge(LocalDate.now());
    }

    @Test
    void getAll() {
        assertEquals(1, checkingAccountService.getAll().size());
    }

    @Test
    void findById() {
        assertEquals(checkingAccount, checkingAccountService.findById(checkingAccount.getId()));
    }

    @Test
    void deleteById() {
        checkingAccountService.deleteById(checkingAccount.getId());
    }
}