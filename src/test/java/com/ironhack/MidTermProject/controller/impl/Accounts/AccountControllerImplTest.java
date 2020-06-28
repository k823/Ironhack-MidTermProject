package com.ironhack.MidTermProject.controller.impl.Accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.classes.Account;
import com.ironhack.MidTermProject.model.classes.Address;
import com.ironhack.MidTermProject.model.classes.Money;
import com.ironhack.MidTermProject.model.dto.AccountMoney;
import com.ironhack.MidTermProject.model.entities.Accounts.CreditCardAccount;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.model.entities.Users.ThirdParty;
import com.ironhack.MidTermProject.repository.Users.ThirdPartyRepository;
import com.ironhack.MidTermProject.repository.Users.UserRepository;
import com.ironhack.MidTermProject.service.Accounts.AccountService;
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
class AccountControllerImplTest {
    @MockBean
    AccountService accountService;

    @MockBean
    UserRepository userRepository;

    @MockBean
    ThirdPartyRepository thirdPartyRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    AccountHolder accountHolder;
    CreditCardAccount creditCardAccount;
    List<Account> accounts;

    ThirdParty thirdParty;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        accountHolder = new AccountHolder("jorge", "$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC", LocalDate.of(1994, 12, 10), new Address("fake123", "springfield", "usa", 9999), null);
        creditCardAccount = new CreditCardAccount(new Money(new BigDecimal(100)), "banana", accountHolder, null, new BigDecimal(500), new BigDecimal(0.2));
        creditCardAccount.setId((long) 1);
        creditCardAccount.setSecretKey("$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC");
        accounts = Arrays.asList(creditCardAccount);

        thirdParty = new ThirdParty();
        thirdParty.setHashedKey("$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC");

        when(accountService.getAll()).thenReturn(accounts);
        when(accountService.findById(creditCardAccount.getId())).thenReturn(creditCardAccount);
        when(userRepository.findByName("jorge")).thenReturn(accountHolder);
        when(thirdPartyRepository.findByHashedKey("$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC")).thenReturn(Arrays.asList(thirdParty));
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/find/all"))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/find/1"))
                .andExpect(status().isOk());
    }

    @Test
    void findMine() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/find/mine")
                .header("Authorization", "am9yZ2U6YmFuYW5h"))
                .andExpect(status().isOk());
    }

    @Test
    void findMineId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/find/mine/1")
                .header("Authorization", "am9yZ2U6YmFuYW5h"))
                .andExpect(status().isOk());
    }

    @Test
    void setBalance() throws Exception {
        AccountMoney accountMoney = new AccountMoney((long) 1, new BigDecimal(100));

        mockMvc.perform(MockMvcRequestBuilders.post("/accounts/balance")
                .header("Authorization", "am9yZ2U6YmFuYW5h")
                .content(objectMapper.writeValueAsString(accountMoney))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}