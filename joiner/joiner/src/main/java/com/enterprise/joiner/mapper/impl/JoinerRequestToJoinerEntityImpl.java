package com.enterprise.joiner.mapper.impl;

import com.enterprise.joiner.mapper.JoinerRequestToJoinerEntity;
import com.enterprise.joiner.model.dto.request.JoinerRequest;
import com.enterprise.joiner.model.entity.JoinerEntity;
import org.springframework.stereotype.Service;

@Service
public class JoinerRequestToJoinerEntityImpl implements JoinerRequestToJoinerEntity {
    @Override
    public JoinerEntity map(JoinerRequest joinerRequest) {
        return JoinerEntity.builder()
                .identificationNumber(joinerRequest.getIdentificationNumber())
                .name(joinerRequest.getName())
                .lastName(joinerRequest.getLastName())
                .stack(joinerRequest.getStack())
                .role(joinerRequest.getRole())
                .englishLevel(joinerRequest.getEnglishLevel())
                .domainExperience(joinerRequest.getDomainExperience())
                .build();
    }

    //@Override
    public JoinerEntity map(JoinerEntity joiner, JoinerRequest joinerRequest) {
        return JoinerEntity.builder()
                .identificationNumber(joinerRequest.getIdentificationNumber())
                .name(joinerRequest.getName())
                .lastName(joinerRequest.getLastName())
                .stack(joinerRequest.getStack())
                .role(joinerRequest.getRole())
                .englishLevel(joinerRequest.getEnglishLevel())
                .domainExperience(joinerRequest.getDomainExperience())
                .build();
    }
}
