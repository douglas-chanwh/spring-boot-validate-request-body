package com.bezkoder.spring.validation;

import com.bezkoder.spring.validation.payload.YourRequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RequestBodyValidationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetEndpoint_ValidRequestBody() throws Exception {
        String requestBody = "{\"field1\": \"value1\", \"field2\": 10}";
        mockMvc.perform(get("/endpoint")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetEndpoint_InvalidRequestBody() throws Exception {
        String requestBody = "{\"field1\": null, \"field2\": null}";
        mockMvc.perform(get("/endpoint")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().is5xxServerError());
    }

    @Test
    public void testGetEndpoint_InvalidRequestBody_Returns400() throws Exception {
        YourRequestBody requestBody = new YourRequestBody();
        requestBody.setField1(null);
        requestBody.setField2(null);

        // Perform the GET request with the invalid request body
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/endpoint")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestBody)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Request body must have at least one non-null property"))
                .andReturn();

        // Get the status code from the MvcResult
        int statusCode = result.getResponse().getStatus();

        // Assert the status code
        assertEquals(400, statusCode);
    }
}