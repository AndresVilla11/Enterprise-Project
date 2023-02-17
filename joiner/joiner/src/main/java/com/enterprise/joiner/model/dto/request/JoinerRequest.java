package com.enterprise.joiner.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JoinerRequest {
    @NotBlank
    private Long identificationNumber;
    @NotBlank
    private String name;
    private String lastName;
    @NotBlank
    private String stack;
    @NotBlank
    private String role;
    @NotBlank
    private String englishLevel;
    @NotBlank
    private String domainExperience;
}
