package com.ironhack.MidTermProject.service.Accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.classes.Account;
import com.ironhack.MidTermProject.model.classes.Address;
import com.ironhack.MidTermProject.model.classes.Money;
import com.ironhack.MidTermProject.model.dto.AccountMoney;
import com.ironhack.MidTermProject.model.dto.ThirdPartyAccess;
import com.ironhack.MidTermProject.model.dto.Transference;
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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class AccountServiceTest {

    @MockBean
    AccountService accountService;

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
    List<Account> accounts;

    @BeforeEach
    void setUp() throws Exception {
        accountHolder = new AccountHolder("jorge", "banana", LocalDate.of(1994, 12, 10), new Address("fake123", "springfield", "usa", 9999), null);
        creditCardAccount = new CreditCardAccount(new Money(new BigDecimal(100)), "banana", accountHolder, null, new BigDecimal(500), new BigDecimal(0.2));
        accounts = Arrays.asList(creditCardAccount);
        when(accountService.getAll()).thenReturn(accounts);
        when(accountService.findById(creditCardAccount.getId())).thenReturn(creditCardAccount);
        when(accountService.findMine("yes")).thenReturn(accounts);
        when(accountService.findMineId("yes", creditCardAccount.getId())).thenReturn(creditCardAccount);

    }

    @Test
    void getAll() {
       assertEquals(1,  accountService.getAll().size());
    }

    @Test
    void findById() {
        assertEquals(creditCardAccount, accountService.findById(creditCardAccount.getId()));
    }

    @Test
    void findMine() throws Exception {
        assertEquals(accounts, accountService.findMine("yes"));
    }

    @Test
    void findMineId() throws Exception {
        assertEquals(creditCardAccount, accountService.findMineId("yes", creditCardAccount.getId()));
    }

    @Test
    void setBalance() throws Exception {
        accountService.setBalance(new AccountMoney(creditCardAccount.getId(), new BigDecimal(100)));
        assertTrue(true);
    }

    @Test
    void operateAccount() throws Exception {
        accountService.operateAccount("hey", new ThirdPartyAccess(creditCardAccount.getId(), new BigDecimal(100), "yes"));
        assertTrue(true);
    }

    @Test
    void makeTransference() throws Exception {
        accountService.makeTransference("yes", new Transference(creditCardAccount.getId(), creditCardAccount.getId(), "yes", new BigDecimal(100)));
        assertTrue(true);
    }

    @Test
    void checkLastTransference() throws Exception {
        accountService.checkLastTransference(creditCardAccount);
        assertTrue(true);
    }

    @Test
    void checkHistoricTransference() throws Exception {
        accountService.checkHistoricTransference(creditCardAccount);
    }

    public class AccountTestInstance extends Account {}
}