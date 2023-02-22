package com.enterprise.joiner.mock;

import com.enterprise.joiner.model.dto.request.JoinerRequest;
import com.enterprise.joiner.model.entity.JoinerEntity;

public class DummyMock {

    public JoinerRequest createJoinerRequest() {
        return JoinerRequest.builder()
                .role("back")
                .stack("java")
                .domainExperience("back")
                .englishLevel("B2")
                .name("John")
                .identificationNumber(123L)
                .lastName("Doe")
                .build();
    }

    public JoinerEntity createJoinerEntity() {
        return JoinerEntity.builder()
                .id(1L)
                .role("back")
                .stack("java")
                .domainExperience("back")
                .englishLevel("B2")
                .name("John")
                .identificationNumber(123L)
                .lastName("Doe")
                .build();
    }

    public JoinerRequest updateJoinerRequestNameStack() {
        return JoinerRequest.builder()
                .name("Dan")
                .stack("go")
                .build();
    }

    public JoinerEntity updateJoinerEntity() {
        return JoinerEntity.builder()
                .id(1L)
                .role("back")
                .stack("go")
                .domainExperience("back")
                .englishLevel("B2")
                .name("Dan")
                .identificationNumber(123L)
                .lastName("Doe")
                .build();
    }
}
