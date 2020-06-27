package com.ironhack.MidTermProject.controller.impl.Accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.classes.Address;
import com.ironhack.MidTermProject.model.classes.Money;
import com.ironhack.MidTermProject.model.entities.Accounts.StudentCheckingAccount;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.service.Accounts.StudentCheckingAccountService;
import com.ironhack.MidTermProject.service.Users.AccountHolderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
class StudentCheckingAccountControllerImplTest {
    @MockBean
    StudentCheckingAccountService studentCheckingAccountService;

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
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        accountHolder = new AccountHolder("jorge", "banana", LocalDate.of(1994, 12, 10), new Address("fake123", "springfield", "usa", 9999), null);
        studentCheckingAccount = new StudentCheckingAccount(new Money(new BigDecimal(100)), "yes", accountHolder, null);
        accounts = Arrays.asList(studentCheckingAccount);
        when(studentCheckingAccountService.createStudentCheckingAccount(studentCheckingAccount)).thenReturn(studentCheckingAccount);
        when(studentCheckingAccountService.getAll()).thenReturn(accounts);
        when(studentCheckingAccountService.findById(studentCheckingAccount.getId())).thenReturn(studentCheckingAccount);
        when(accountHolderService.findById(studentCheckingAccount.getId())).thenReturn(accountHolder);
    }

//    @Test
//    void createStudentCheckingAccount() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/accounts/student/new")
//                .header("Authorization", "am9yZ2U6YmFuYW5h")
//                .content(objectMapper.writeValueAsString(studentCheckingAccount))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated());
//    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/student/find/all"))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/student/find/1"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/accounts/student/delete/1"))
                .andExpect(status().isNoContent());
    }
}