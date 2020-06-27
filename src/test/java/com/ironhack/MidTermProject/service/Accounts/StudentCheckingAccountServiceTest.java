package com.ironhack.MidTermProject.service.Accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.classes.Address;
import com.ironhack.MidTermProject.model.classes.Money;
import com.ironhack.MidTermProject.model.entities.Accounts.StudentCheckingAccount;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.repository.Accounts.StudentCheckingAccountRepository;
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
class StudentCheckingAccountServiceTest {
    @Autowired
    StudentCheckingAccountService studentCheckingAccountService;

    @MockBean
    StudentCheckingAccountRepository studentCheckingAccountRepository;

    @MockBean
    AccountHolderService accountHolderService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    public MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    AccountHolder accountHolder;
    StudentCheckingAccount studentCheckingAccount;
    List<StudentCheckingAccount> accounts;

    @BeforeEach
    void setUp() throws Exception {
        accountHolder = new AccountHolder("jorge", "banana", LocalDate.of(1994, 12, 10), new Address("fake123", "springfield", "usa", 9999), null);
        studentCheckingAccount = new StudentCheckingAccount(new Money(new BigDecimal(100)), "yes", accountHolder, null);
        accounts = Arrays.asList(studentCheckingAccount);
        when(studentCheckingAccountRepository.save(studentCheckingAccount)).thenReturn(studentCheckingAccount);
        when(studentCheckingAccountRepository.findAll()).thenReturn(accounts);
        when(studentCheckingAccountRepository.findById(studentCheckingAccount.getId())).thenReturn(java.util.Optional.ofNullable(studentCheckingAccount));
        when(accountHolderService.findById(studentCheckingAccount.getId())).thenReturn(accountHolder);
    }

    @Test
    void createStudentCheckingAccount() {
        assertEquals(studentCheckingAccount, studentCheckingAccountService.createStudentCheckingAccount(studentCheckingAccount));
    }

    @Test
    void getAll() {
        assertEquals(1, studentCheckingAccountService.getAll().size());
    }

    @Test
    void findById() {
        assertEquals(studentCheckingAccount, studentCheckingAccountService.findById(studentCheckingAccount.getId()));
    }

    @Test
    void deleteById() {
        studentCheckingAccountService.deleteById(studentCheckingAccount.getId());
    }
}