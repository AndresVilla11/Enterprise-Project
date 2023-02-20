package com.enterprise.joiner.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JoinerResponse {
    private Long identificationNumber;
    private String name;
    private String status;
}