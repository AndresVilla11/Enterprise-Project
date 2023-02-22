package com.enterprise.joiner.service.impl;

import com.enterprise.joiner.exception.DuplicateDataBaseException;
import com.enterprise.joiner.mapper.JoinerRequestToJoinerEntity;
import com.enterprise.joiner.mock.DummyMock;
import com.enterprise.joiner.model.dto.request.JoinerRequest;
import com.enterprise.joiner.model.dto.response.JoinerResponse;
import com.enterprise.joiner.model.entity.JoinerEntity;
import com.enterprise.joiner.repository.JoinerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class JoinerServiceImplTest {

    @Mock
    private JoinerRepository joinerRepository;

    @Mock
    private JoinerRequestToJoinerEntity joinerRequestToJoinerEntity;

    @InjectMocks
    private JoinerServiceImpl joinerService;
    private DummyMock dummyMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        dummyMock = new DummyMock();
    }

    @Test
    void createJoinerSuccesful() {
        JoinerRequest joinerRequest = dummyMock.createJoinerRequest();
        when(joinerRepository.save(any(JoinerEntity.class))).thenReturn(dummyMock.createJoinerEntity());
        when(joinerRequestToJoinerEntity.map(any(JoinerRequest.class))).thenReturn(dummyMock.createJoinerEntity());
        JoinerResponse joiner = joinerService.createJoiner(joinerRequest);

        assertEquals(joinerRequest.getName(), joiner.getName());
        assertEquals(joinerRequest.getIdentificationNumber(), joiner.getIdentificationNumber());
        assertEquals("Success", joiner.getStatus());
    }

    @Test
    void createJoinerValidateDuplicateDataBaseException() {
        JoinerRequest joinerRequest = dummyMock.createJoinerRequest();
        when(joinerRepository.findByIdentificationNumber(anyLong())).thenReturn(new JoinerEntity());
        Exception exception = assertThrows(DuplicateDataBaseException.class, () -> {
            joinerService.createJoiner(joinerRequest);
        });

        assertEquals("Duplicate data in database null identification number", exception.getMessage());
    }

    @Test
    void updateJoinerSuccessful() {
        JoinerRequest joinerRequest = dummyMock.updateJoinerRequestNameStack();
        when(joinerRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(dummyMock.createJoinerEntity()));
        when(joinerRepository.save(any(JoinerEntity.class))).thenReturn(dummyMock.updateJoinerEntity());
        JoinerResponse joinerResponse = joinerService.updateJoiner(1l, joinerRequest);
        assertEquals(joinerRequest.getName(), joinerResponse.getName());
    }

    @Test
    void updateJoinerException() {
        JoinerRequest joinerRequest = dummyMock.updateJoinerRequestNameStack();
        when(joinerRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(null));
        when(joinerRepository.save(any(JoinerEntity.class))).thenReturn(dummyMock.updateJoinerEntity());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            joinerService.updateJoiner(1l, joinerRequest);
        });

        assertEquals("Joiner with id: 1 not found.", exception.getMessage());
    }

    @Test
    void updateJoinerWithEmptyBody() {
        JoinerRequest joinerRequest = dummyMock.updateJoinerRequestNameStack();
        when(joinerRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(dummyMock.createJoinerEntity()));
        when(joinerRepository.save(any(JoinerEntity.class))).thenReturn(dummyMock.updateJoinerEntity());
        JoinerResponse joinerResponse = joinerService.updateJoiner(1l, new JoinerRequest());
        assertEquals(joinerRequest.getName(), joinerResponse.getName());
    }
}