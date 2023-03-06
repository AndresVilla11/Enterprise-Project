package com.enterprise.joiner.service.impl;

import com.enterprise.joiner.exception.DuplicateDataBaseException;
import com.enterprise.joiner.mapper.JoinerRequestToJoinerEntity;
import com.enterprise.joiner.model.dto.request.JoinerRequest;
import com.enterprise.joiner.model.dto.response.JoinerResponse;
import com.enterprise.joiner.model.entity.JoinerEntity;
import com.enterprise.joiner.repository.JoinerRepository;
import com.enterprise.joiner.service.JoinerService;
import com.enterprise.joiner.utils.Constants;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JoinerServiceImpl implements JoinerService {
    private final JoinerRepository joinerRepository;
    private final JoinerRequestToJoinerEntity joinerRequestToJoinerEntity;

    @Override
    public JoinerResponse createJoiner(JoinerRequest joinerRequest) {
        validateIdentificationNumber(joinerRequest);
        JoinerEntity savedJoiner = joinerRepository.save(joinerRequestToJoinerEntity.map(joinerRequest));
        return JoinerResponse.builder()
                .identificationNumber(savedJoiner.getIdentificationNumber())
                .name(savedJoiner.getName())
                .status("Success")
                .build();
    }

    private void validateIdentificationNumber(JoinerRequest joinerRequest) {
        Optional.ofNullable(joinerRepository.findByIdentificationNumber(joinerRequest.getIdentificationNumber())).ifPresent(
                (joinerEntity) -> {
                    throw new DuplicateDataBaseException(Constants.exceptionIdentification(joinerEntity.getIdentificationNumber()));
                }
        );
    }

    @Override
    public JoinerResponse updateJoiner(Long joinerId, JoinerRequest newJoinerInfo) {
        JoinerEntity joiner = Optional.of(joinerRepository.findById(joinerId))
                .get()
                .orElseThrow(() -> new IllegalArgumentException("Joiner with id: " + joinerId + " not found."));

        JoinerEntity updatedJoiner = joinerRepository.save(updateJoinerInfo(joiner, newJoinerInfo));

        return JoinerResponse.builder()
                .identificationNumber(updatedJoiner.getIdentificationNumber())
                .name(updatedJoiner.getName())
                .status("Updated")
                .build();
    }

    private JoinerEntity updateJoinerInfo(JoinerEntity joiner, JoinerRequest newJoinerInfo) {

        Long identificationNumber = newJoinerInfo.getIdentificationNumber();
        if (identificationNumber != null) {
            joiner.setIdentificationNumber(identificationNumber);
        }

        String name = newJoinerInfo.getName();
        if (StringUtils.isNotBlank(name)) {
            joiner.setName(name);
        }

        String lastName = newJoinerInfo.getLastName();
        if (StringUtils.isNotBlank(lastName)) {
            joiner.setLastName(lastName);
        }


        String role = newJoinerInfo.getRole();
        if (StringUtils.isNotBlank(role)) {
            joiner.setRole(role);
        }

        String englishLevel = newJoinerInfo.getEnglishLevel();
        if (StringUtils.isNotBlank(englishLevel)) {
            joiner.setEnglishLevel(englishLevel);
        }

        String domainExperience = newJoinerInfo.getDomainExperience();
        if (StringUtils.isNotBlank(domainExperience)) {
            joiner.setDomainExperience(domainExperience);
        }

        String stack = newJoinerInfo.getStack();
        if (StringUtils.isNotBlank(stack)) {
            joiner.setStack(stack);
        }

        return joiner;
    }
}
