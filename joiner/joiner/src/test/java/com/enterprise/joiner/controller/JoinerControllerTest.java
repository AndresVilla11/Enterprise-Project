package com.enterprise.joiner.controller;

import com.enterprise.joiner.mock.DummyMock;
import com.enterprise.joiner.model.dto.request.JoinerRequest;
import com.enterprise.joiner.service.impl.JoinerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = JoinerController.class)
class JoinerControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    JoinerServiceImpl joinerService;

    private DummyMock dummyMock;

    @BeforeEach
    void setUp() {
        dummyMock = new DummyMock();
    }

    @Test
    void getJoiner() throws Exception {
        MvcResult mvcResult = mvc.perform(get("/api/joiners")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String result = "Hello Joiner";
        assertEquals(result, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void createJoiner() throws Exception {
        JoinerRequest joinerRequest = dummyMock.createJoinerRequest();
        MvcResult mvcResult = mvc.perform(post("/api/joiners")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(joinerRequest)))
                .andExpect(status().isCreated()).andReturn();
    }

    @Test
    void createJoinerWhenNullExpectsBadRequest() throws Exception {
        JoinerRequest joinerRequest = dummyMock.createJoinerRequest();
        joinerRequest.setIdentificationNumber(null);
        mvc.perform(post("/api/joiners")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(joinerRequest)))
                .andExpect(status().isBadRequest());

    }

    @Test
    void updateJoiner() {
    }
}