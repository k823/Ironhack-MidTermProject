package com.ironhack.MidTermProject.service.Accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.classes.Address;
import com.ironhack.MidTermProject.model.classes.Money;
import com.ironhack.MidTermProject.model.dto.CheckingAccountDto;
import com.ironhack.MidTermProject.model.entities.Accounts.CheckingAccount;
import com.ironhack.MidTermProject.model.entities.Accounts.StudentCheckingAccount;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.repository.Accounts.CheckingAccountRepository;
import com.ironhack.MidTermProject.repository.Accounts.StudentCheckingAccountRepository;
import com.ironhack.MidTermProject.repository.Users.AccountHolderRepository;
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
class CheckingAccountServiceTest {

    @Autowired
    CheckingAccountService checkingAccountService;

    @MockBean
    CheckingAccountRepository checkingAccountRepository;

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
    CheckingAccountDto checkingAccountDto;
    StudentCheckingAccount studentCheckingAccount;
    List<CheckingAccount> accounts;

    @BeforeEach
    void setUp() {
        accountHolder = new AccountHolder("jorge", "banana", LocalDate.of(1994, 12, 10), new Address("fake123", "springfield", "usa", 9999), null);
        checkingAccount = new CheckingAccount(new Money(new BigDecimal(100)), "yes", accountHolder, null);
        checkingAccountDto = new CheckingAccountDto(accountHolder.getId(), new BigDecimal(100), "yes");
        studentCheckingAccount = new StudentCheckingAccount(new Money(new BigDecimal(100)), "yes", accountHolder, null);
        accounts = Arrays.asList(checkingAccount);
        when(checkingAccountRepository.save(checkingAccount)).thenReturn(checkingAccount);
        when(studentCheckingAccountRepository.save(studentCheckingAccount)).thenReturn(studentCheckingAccount);
        when(checkingAccountRepository.findAll()).thenReturn(accounts);
        when(checkingAccountRepository.findById(checkingAccount.getId())).thenReturn(java.util.Optional.ofNullable(checkingAccount));
        when(accountHolderRepository.findById(checkingAccount.getId())).thenReturn(java.util.Optional.ofNullable(accountHolder));
    }

    @Test
    void createCheckingAccount() {
        assertEquals(checkingAccount, checkingAccountService.createCheckingAccount(checkingAccount));
    }

    @Test
    void checkAccountType() throws Exception {
        assertEquals(null, checkingAccountService.checkAccountType(checkingAccountDto));
        accountHolder.setBirthDate(LocalDate.now());
        assertEquals(null, checkingAccountService.checkAccountType(checkingAccountDto));
        assertThrows(Exception.class, () -> checkingAccountService.checkAccountType(null));
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