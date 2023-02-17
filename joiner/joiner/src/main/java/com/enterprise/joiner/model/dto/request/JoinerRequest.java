package com.enterprise.joiner.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JoinerRequest {
    @NotNull
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
