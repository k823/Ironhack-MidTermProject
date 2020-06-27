package com.ironhack.MidTermProject.controller.impl.Users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.MidTermProject.model.entities.Users.ThirdParty;
import com.ironhack.MidTermProject.repository.Users.ThirdPartyRepository;
import com.ironhack.MidTermProject.service.Users.ThirdPartyService;
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

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ThirdPartyControllerImplTest {

    @Autowired
    ThirdPartyService thirdPartyService;

    @MockBean
    ThirdPartyRepository thirdPartyRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    ThirdParty thirdParty;
    List<ThirdParty> thirdParties;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        thirdParty= new ThirdParty("third", "party", "test");
        thirdParty.setId((long) 1);
        thirdParties = Arrays.asList(thirdParty);

        when(thirdPartyRepository.findAll()).thenReturn(thirdParties);
        when(thirdPartyRepository.findById(thirdParty.getId())).thenReturn(java.util.Optional.ofNullable(thirdParty));
        when(thirdPartyRepository.save(thirdParty)).thenReturn(thirdParty);
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/third-party/find/all"))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/third-party/find/1"))
                .andExpect(status().isOk());
    }

    @Test
    void createThirdParty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/third-party/new")
                .header("Authorization", "am9yZ2U6YmFuYW5h")
                .content(objectMapper.writeValueAsString(thirdParty))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/third-party/delete/1"))
                .andExpect(status().isNoContent());
    }
}