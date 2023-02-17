package com.enterprise.joiner.model.dto.request;

import lombok.Data;

@Data
public class JoinerRequest {
    private Long identificationNumber;
    private String name;
    private String lastName;
    private String stack;
    private String role;
    private String englishLevel;
    private String domainExperience;
}
