package com.enterprise.joiner.mock;

import com.enterprise.joiner.model.dto.request.JoinerRequest;
import com.enterprise.joiner.model.entity.JoinerEntity;
import org.hibernate.mapping.Join;

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

    public JoinerRequest createIncompleteJoinerRequest() {
        return JoinerRequest.builder()
                .role("back")
                .stack("java")
                .domainExperience("back")
                .englishLevel("B2")
                .name("John")
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

    public JoinerRequest updateJoinerRequestNullValues() {
        return JoinerRequest.builder()
                .role(null)
                .stack(null)
                .domainExperience(null)
                .englishLevel(null)
                .name(null)
                .identificationNumber(null)
                .lastName(null)
                .build();
    }

    public JoinerRequest updateJoinerRequestName() {
        return JoinerRequest.builder()
                .name("")
                .build();
    }

    public JoinerEntity updateJoinerEntityName() {
        return JoinerEntity.builder()
                .name("Dan")
                .build();
    }

    public JoinerRequest updateJoinerRequestNameStack() {
        return JoinerRequest.builder()
                .name("Dan")
                .stack("go")
                .build();
    }

    public JoinerRequest updateJoinerRequestIdentificationNumber() {
        return JoinerRequest.builder()
                .identificationNumber(1234L)
                .build();
    }

    public JoinerEntity updateJoinerEntityIdentificationNumber() {
        return JoinerEntity.builder()
                .identificationNumber(1234L)
                .build();
    }
    public JoinerRequest updateJoinerRequestRole() {
        return JoinerRequest.builder()
                .role("front")
                .build();
    }

    public JoinerEntity updateJoinerEntityRole() {
        return JoinerEntity.builder()
                .role("front")
                .build();
    }

    public JoinerEntity updateJoinerEntityNameStack() {
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

    public JoinerEntity updateJoinerEntity() {
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
}
