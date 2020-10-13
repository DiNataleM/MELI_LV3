package com.meli.lv2.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class MutantCheckerControllerIntTest {

    public static final String MUTANT_URL = "/mutant";

    @Autowired
    private MockMvc mvc;

    @Test
    public void test_isOk() throws Exception {
        mvc.perform(post(MUTANT_URL)
                .content("{\n" +
                        "\"dna\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]\n" +
                        "}\n")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void test_isForbidden() throws Exception {
        mvc.perform(post(MUTANT_URL)
                .content("{\n" +
                        "\"dna\":[\"TTGCAA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCACTA\",\"TCACTG\"]\n" +
                        "}\n")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }


    @Test
    public void test_isParamError() throws Exception {
        mvc.perform(post(MUTANT_URL)
                .content("{\n" +
                        "\"dna\":[\"TTGCA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCACTA\",\"TCACTG\"]\n" +
                        "}\n")
                .contentType(APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(content().json("{\"httpStatus\":\"BAD_REQUEST\",\"message\":\"The dna parameter is not NXN.\"}"));
    }
}
