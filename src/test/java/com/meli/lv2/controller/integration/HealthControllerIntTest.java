package com.meli.lv2.controller.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class HealthControllerIntTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void healthCheck() throws Exception {
        MvcResult result = mvc.perform(get("/")).andExpect(status().isOk()).andReturn();

        assertEquals("OK", result.getResponse().getContentAsString());
    }
}