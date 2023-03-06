package com.enterprise.joiner.integration;

import com.enterprise.joiner.mock.DummyMock;
import com.enterprise.joiner.service.impl.JoinerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JoinerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    JoinerServiceImpl joinerService;

    private DummyMock dummyMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        dummyMock = new DummyMock();
    }

    @Test
    void getJoiner() {
        ResponseEntity<String> forEntity = testRestTemplate.getForEntity("/api/joiners", String.class);
        assertEquals(HttpStatus.OK, forEntity.getStatusCode());
        assertEquals("Hello Joiner", forEntity.getBody());
    }

    @Test
    void createJoiner() {
        ResponseEntity<String> stringResponseEntity = testRestTemplate.postForEntity("/api/joiners", dummyMock.createJoinerRequest(), String.class);
        stringResponseEntity.getStatusCode();
    }

    @Test
    void updateJoiner() {
    }
}