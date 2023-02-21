package com.enterprise.joiner.mapper.impl;

import com.enterprise.joiner.mock.DummyMock;
import com.enterprise.joiner.model.dto.request.JoinerRequest;
import com.enterprise.joiner.model.entity.JoinerEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class JoinerRequestToJoinerEntityImplTest {

    @InjectMocks
    private JoinerRequestToJoinerEntityImpl joinerRequestToJoinerEntityImpl;
    private DummyMock dummyMock;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        dummyMock = new DummyMock();
    }

    @Test
    void map() {
        JoinerRequest joinerRequest = dummyMock.createJoinerRequest();
        JoinerEntity joinerEntity = joinerRequestToJoinerEntityImpl.map(joinerRequest);
        assertEquals(JoinerEntity.class, joinerEntity.getClass());

    }
}