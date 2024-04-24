package com.bezkoder.spring.validation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetUsers_WithNoRequestParams_ReturnsBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("At least one request parameter must be provided"));
    }

    @Test
    public void testGetUsers_WithValidRequestParams_ReturnsOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users")
                        .param("name", "John"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}