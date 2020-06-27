package com.ironhack.MidTermProject.service.Accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.classes.Address;
import com.ironhack.MidTermProject.model.classes.Money;
import com.ironhack.MidTermProject.model.entities.Accounts.CreditCardAccount;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.repository.Accounts.CreditCardAccountRepository;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class CreditCardAccountServiceTest {
    @Autowired
    CreditCardAccountService creditCardAccountService;

    @MockBean
    CreditCardAccountRepository creditCardAccountRepository;

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
        creditCardAccount = new CreditCardAccount(new Money(new BigDecimal(100)), "yes", accountHolder, null, new BigDecimal(500), new BigDecimal(0.2));
        accounts = Arrays.asList(creditCardAccount);

        when(creditCardAccountRepository.save(creditCardAccount)).thenReturn(creditCardAccount);
        when(creditCardAccountRepository.findAll()).thenReturn(accounts);
        when(creditCardAccountRepository.findById(creditCardAccount.getId())).thenReturn(java.util.Optional.ofNullable(creditCardAccount));
        when(accountHolderService.findById(creditCardAccount.getId())).thenReturn(accountHolder);

    }

    @Test
    void createCreditCardAccount() {
        assertEquals(creditCardAccount, creditCardAccountService.createCreditCardAccount(creditCardAccount));
        creditCardAccount.setInterestRate(null);
        assertThrows(Exception.class, () -> creditCardAccountService.createCreditCardAccount(creditCardAccount));
        creditCardAccount.setCreditLimit(null);
        assertThrows(Exception.class, () -> creditCardAccountService.createCreditCardAccount(creditCardAccount));
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

    @Test
    void addInterest() {
        creditCardAccountService.addInterest(creditCardAccount);
    }
}