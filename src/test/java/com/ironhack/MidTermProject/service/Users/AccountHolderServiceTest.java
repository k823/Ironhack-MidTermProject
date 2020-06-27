package com.ironhack.MidTermProject.service.Users;

import com.ironhack.MidTermProject.model.classes.Address;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.repository.Users.AccountHolderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class AccountHolderServiceTest {

    @Autowired
    AccountHolderService accountHolderService;

    @MockBean
    AccountHolderRepository accountHolderRepository;

    AccountHolder accountHolder;
    List<AccountHolder> accountHolders;

    @BeforeEach
    void setUp() {
        accountHolder = new AccountHolder("account", "holder", LocalDate.of(1993, 1, 1), new Address("fake", "springfield", "usa", 123), null);
        accountHolders = Arrays.asList(accountHolder);

        when(accountHolderRepository.save(accountHolder)).thenReturn(accountHolder);
        when(accountHolderRepository.findAll()).thenReturn(accountHolders);
        when(accountHolderRepository.findById(accountHolder.getId())).thenReturn(java.util.Optional.ofNullable(accountHolder));
    }

    @Test
    void getAll() {
        assertEquals(1, accountHolderService.getAll().size());
    }

    @Test
    void findById() {
        assertEquals(accountHolder, accountHolderService.findById(accountHolder.getId()));
    }

    @Test
    void createAccountHolder() throws Exception {
        assertEquals(accountHolder, accountHolderService.createAccountHolder(accountHolder));
        accountHolder = new AccountHolder(null, null, null, null, null);
        assertThrows(Exception.class, () -> accountHolderService.createAccountHolder(accountHolder));
        accountHolder = new AccountHolder("hey", null, null, null, null);
        assertThrows(Exception.class, () -> accountHolderService.createAccountHolder(accountHolder));
        accountHolder = new AccountHolder("hey", null, LocalDate.of(1993, 1, 1), null, null);
        assertThrows(Exception.class, () -> accountHolderService.createAccountHolder(accountHolder));
    }

    @Test
    void deleteById() {
        accountHolderService.deleteById(accountHolder.getId());
    }
}