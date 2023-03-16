package com.example.unit_test_epsi_exam_b3.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_game_endpoint() throws Exception {

        MvcResult result = mockMvc.perform(get("/game")).andDo(print()).andExpect(status().isOk()).andReturn();

        String content = result.getResponse().getContentAsString();

        assertEquals("Hello Game !", content);
    }

    @Test
    public void test_game_action() throws Exception {

        MvcResult result = mockMvc.perform(get("/game/play/rock")).andDo(print()).andExpect(status().isOk()).andReturn();

        String content = result.getResponse().getContentAsString();

        assertThat(content, containsString("Vous avez joué rock et l'ordinateur a joué rock. Vous avez fait égalité"));

    }
}
