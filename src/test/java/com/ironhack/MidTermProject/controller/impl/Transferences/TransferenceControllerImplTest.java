package com.ironhack.MidTermProject.controller.impl.Transferences;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.classes.Address;
import com.ironhack.MidTermProject.model.classes.Money;
import com.ironhack.MidTermProject.model.dto.ThirdPartyAccess;
import com.ironhack.MidTermProject.model.entities.Accounts.SavingsAccount;
import com.ironhack.MidTermProject.model.entities.Transferences.TransferenceRegistry;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.model.entities.Users.ThirdParty;
import com.ironhack.MidTermProject.repository.Accounts.AccountRepository;
import com.ironhack.MidTermProject.repository.Users.AccountHolderRepository;
import com.ironhack.MidTermProject.repository.Users.ThirdPartyRepository;
import com.ironhack.MidTermProject.service.Transferences.TransferenceRegistryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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
class TransferenceControllerImplTest {
    @MockBean
    TransferenceRegistryService transferenceRegistryService;

    @MockBean
    ThirdPartyRepository thirdPartyRepository;

    @MockBean
    AccountRepository accountRepository;

    @MockBean
    AccountHolderRepository accountHolderRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    public MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    TransferenceRegistry transferenceRegistry;
    List<TransferenceRegistry> registries;

    ThirdParty thirdParty;
    SavingsAccount savingsAccount;
    AccountHolder accountHolder;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        transferenceRegistry = new TransferenceRegistry(null, null, null, null, null, null, null);
        registries = Arrays.asList(transferenceRegistry);

        thirdParty= new ThirdParty("third", "party", "$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC");

        accountHolder = new AccountHolder("account", "holder", LocalDate.of(1993, 1, 1), new Address("fake", "springfield", "usa", 123), null);

        savingsAccount = new SavingsAccount(new Money(new BigDecimal(100)), "yes", accountHolder, null, new BigDecimal(300), new BigDecimal(0.1));
        savingsAccount.setId((long) 1);

        when(transferenceRegistryService.createTransferenceRegistry(transferenceRegistry)).thenReturn(transferenceRegistry);
        when(transferenceRegistryService.getAll()).thenReturn(registries);
        when(transferenceRegistryService.findById(transferenceRegistry.getId())).thenReturn(transferenceRegistry);
        when(thirdPartyRepository.findByHashedKey(thirdParty.getHashedKey())).thenReturn(Arrays.asList(thirdParty));
        when(accountRepository.findById(savingsAccount.getId())).thenReturn(java.util.Optional.ofNullable(savingsAccount));
        when(accountHolderRepository.findById(savingsAccount.getPrimaryOwner().getId())).thenReturn(java.util.Optional.ofNullable(accountHolder));

    }

    @Test
    void makeTransference() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/transference/new")
                .header("Authorization", "am9yZ2U6YmFuYW5h")
                .content(objectMapper.writeValueAsString(transferenceRegistry))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/transference/find/all"))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/transference/find/1"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteTransferenceRegistryById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/transference/delete/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void operateAccount() throws Exception {
        ThirdPartyAccess thirdPartyAccess = new ThirdPartyAccess(savingsAccount.getId(), new BigDecimal(100), savingsAccount.getSecretKey());
        mockMvc.perform(MockMvcRequestBuilders.post("/transference/third-party/new")
                .header("HashedKey", "$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC")
                .content(objectMapper.writeValueAsString(thirdPartyAccess))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}