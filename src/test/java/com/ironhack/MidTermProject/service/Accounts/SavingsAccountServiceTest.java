package com.ironhack.MidTermProject.service.Accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.classes.Address;
import com.ironhack.MidTermProject.model.classes.Money;
import com.ironhack.MidTermProject.model.entities.Accounts.SavingsAccount;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.repository.Accounts.SavingsAccountRepository;
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
class SavingsAccountServiceTest {
    @Autowired
    SavingsAccountService savingsAccountService;

    @MockBean
    SavingsAccountRepository savingsAccountRepository;

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
        accountHolder = new AccountHolder("jorge", "banana", LocalDate.of(1994, 12, 10), new Address("fake123", "springfield", "usa", 9999), null);
        savingsAccount = new SavingsAccount(new Money(new BigDecimal(100)), "yes", accountHolder, null, new BigDecimal(300), new BigDecimal(0.1));
        accounts = Arrays.asList(savingsAccount);
        when(savingsAccountRepository.save(savingsAccount)).thenReturn(savingsAccount);
        when(savingsAccountRepository.findAll()).thenReturn(accounts);
        when(savingsAccountRepository.findById(savingsAccount.getId())).thenReturn(java.util.Optional.ofNullable(savingsAccount));
        when(accountHolderService.findById(savingsAccount.getId())).thenReturn(accountHolder);
    }

    @Test
    void createSavingsAccount() throws Exception {
        assertEquals(savingsAccount, savingsAccountService.createSavingsAccount(savingsAccount));
    }

    @Test
    void getAll() {
        assertEquals(1, savingsAccountService.getAll().size());
    }

    @Test
    void findById() {
        assertEquals(savingsAccount, savingsAccountService.findById(savingsAccount.getId()));
    }

    @Test
    void deleteById() {
        savingsAccountService.deleteById(savingsAccount.getId());
    }

    @Test
    void addInterest() {
        savingsAccountService.addInterest(savingsAccount);
    }
}