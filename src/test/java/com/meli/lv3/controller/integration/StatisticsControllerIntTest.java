package com.meli.lv3.controller.integration;

import com.meli.lv3.db.repository.DNARepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class StatisticsControllerIntTest {

    public static final String MUTANT_URL = "/mutant";
    public static final String URL_STATS = "/stats";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private DNARepository dnaRepository;

    @Test
    public void testGetStats() throws Exception {
        //Mutant
        mvc.perform(post(MUTANT_URL)
                .content("{\n" +
                        "\"dna\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]\n" +
                        "}\n")
                .contentType(APPLICATION_JSON));

        //Mutant -- repeat
        mvc.perform(post(MUTANT_URL)
                .content("{\n" +
                        "\"dna\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]\n" +
                        "}\n")
                .contentType(APPLICATION_JSON));

        //Human
        mvc.perform(post(MUTANT_URL)
                .content("{\n" +
                        "\"dna\":[\"TTGCAA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCACTA\",\"TCACTG\"]\n" +
                        "}\n")
                .contentType(APPLICATION_JSON));

        //Human - Repeat
        mvc.perform(post(MUTANT_URL)
                .content("{\n" +
                        "\"dna\":[\"TTGCAA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCACTA\",\"TCACTG\"]\n" +
                        "}\n")
                .contentType(APPLICATION_JSON));

        //Human
        mvc.perform(post(MUTANT_URL)
                .content("{\n" +
                        "\"dna\":[\"TTGCAC\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCACTA\",\"TCACTG\"]\n" +
                        "}\n")
                .contentType(APPLICATION_JSON));

        int tryNumber = 5;
        do {
            Thread.sleep(100);
        } while (dnaRepository.count() < 3 && tryNumber-- > 0);

        MvcResult result = mvc.perform(get(URL_STATS)).andExpect(status().isOk()).andReturn();

        assertEquals("{\"count_human_dna\":2,\"count_mutant_dna\":1,\"ratio\":0.5}", result.getResponse().getContentAsString());
    }
}
