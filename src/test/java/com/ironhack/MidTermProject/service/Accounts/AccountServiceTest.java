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
import com.ironhack.MidTermProject.model.entities.Users.ThirdParty;
import com.ironhack.MidTermProject.model.enums.AccountStatus;
import com.ironhack.MidTermProject.repository.Accounts.AccountRepository;
import com.ironhack.MidTermProject.repository.Users.ThirdPartyRepository;
import com.ironhack.MidTermProject.repository.Users.UserRepository;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @MockBean
    AccountRepository accountRepository;

    @MockBean
    UserRepository userRepository;

    @MockBean
    ThirdPartyRepository thirdPartyRepository;

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

    ThirdParty thirdParty;

    @BeforeEach
    void setUp() throws Exception {
        accountHolder = new AccountHolder("jorge", "$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC", LocalDate.of(1994, 12, 10), new Address("fake123", "springfield", "usa", 9999), null);
        creditCardAccount = new CreditCardAccount(new Money(new BigDecimal(100)), "banana", accountHolder, null, new BigDecimal(500), new BigDecimal(0.2));
        creditCardAccount.setId((long) 1);
        creditCardAccount.setSecretKey("$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC");
        accounts = Arrays.asList(creditCardAccount);

        thirdParty = new ThirdParty();
        thirdParty.setHashedKey("$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC");

        when(accountRepository.findAll()).thenReturn(accounts);
        when(accountRepository.findById(creditCardAccount.getId())).thenReturn(java.util.Optional.ofNullable(creditCardAccount));
        when(userRepository.findByName("jorge")).thenReturn(accountHolder);
        when(thirdPartyRepository.findByHashedKey("$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC")).thenReturn(Arrays.asList(thirdParty));

    }

    @Test
    void getAll() {
       assertEquals(1, accountService.getAll().size());
    }

    @Test
    void findById() {
        assertEquals(creditCardAccount, accountService.findById(creditCardAccount.getId()));
    }

    @Test
    void findMine() throws Exception {
        assertEquals(accounts, accountService.findMine("am9yZ2U6YmFuYW5h"));
        assertThrows(Exception.class, () -> accountService.findMine("am9yZ2U6Y2hvcml6bw=="));
    }

    @Test
    void findMineId() throws Exception {
        assertEquals(creditCardAccount, accountService.findMineId("am9yZ2U6YmFuYW5h", creditCardAccount.getId()));
        assertThrows(Exception.class, () -> accountService.findMineId("am9yZ2U6YmFuYW5h", (long) 999));
    }

    @Test
    void setBalance() throws Exception {
        accountService.setBalance(new AccountMoney(creditCardAccount.getId(), new BigDecimal(100)));
        assertTrue(true);
    }

    @Test
    void operateAccount() throws Exception {
        accountService.operateAccount("$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC", new ThirdPartyAccess(creditCardAccount.getId(), new BigDecimal(100), "$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC"));
        assertThrows(Exception.class, () -> accountService.operateAccount(null, null));
        assertThrows(Exception.class, () -> accountService.operateAccount(null, new ThirdPartyAccess(null, null, null)));
    }

    @Test
    void makeTransference() throws Exception {
        accountService.makeTransference("am9yZ2U6YmFuYW5h", new Transference(creditCardAccount.getId(), creditCardAccount.getId(), creditCardAccount.getPrimaryOwner().getName(), new BigDecimal(100)));
        assertThrows(Exception.class, () -> accountService.makeTransference(null, new Transference(null, null, null, null)));
        assertThrows(Exception.class, () ->  accountService.makeTransference("am9yZ2U6YmFuYW5h", new Transference(creditCardAccount.getId(), creditCardAccount.getId(), creditCardAccount.getPrimaryOwner().getName(), new BigDecimal(1000000000))));
        assertThrows(Exception.class, () ->  accountService.makeTransference("am9yZ2U6YmFuYW5h", new Transference(creditCardAccount.getId(), creditCardAccount.getId(), "helloitsmemario", new BigDecimal(100))));
        creditCardAccount.setMaxTransactions24Hrs(0);
        assertThrows(Exception.class, () ->  accountService.makeTransference("am9yZ2U6YmFuYW5h", new Transference(creditCardAccount.getId(), creditCardAccount.getId(), creditCardAccount.getPrimaryOwner().getName(), new BigDecimal(100))));
        creditCardAccount.setStatus(AccountStatus.FROZEN);
        assertThrows(Exception.class, () ->  accountService.makeTransference("am9yZ2U6YmFuYW5h", new Transference(creditCardAccount.getId(), creditCardAccount.getId(), creditCardAccount.getPrimaryOwner().getName(), new BigDecimal(100))));
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
}