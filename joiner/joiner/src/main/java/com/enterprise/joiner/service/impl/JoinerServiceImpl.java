package com.enterprise.joiner.service.impl;

import com.enterprise.joiner.model.dto.request.JoinerRequest;
import com.enterprise.joiner.model.dto.response.JoinerResponse;
import com.enterprise.joiner.model.entity.JoinerEntity;
import com.enterprise.joiner.repository.JoinerRepository;
import com.enterprise.joiner.service.JoinerService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JoinerServiceImpl implements JoinerService {
    @Autowired
    JoinerRepository joinerRepository;
    @Override
    public JoinerResponse updateJoiner(Long joinerId, JoinerRequest newJoinerInfo) {
        JoinerEntity joiner = Optional.of(joinerRepository.findById(joinerId))
                .get()
                .orElseThrow(() -> new IllegalArgumentException("Joiner with id: " + joinerId + " not found."));

        JoinerEntity updatedJoiner= joinerRepository.save(updateJoinerInfo(joiner, newJoinerInfo));

        return JoinerResponse.builder()
                .identificationNumber(updatedJoiner.getIdentificationNumber())
                .name(updatedJoiner.getName())
                .status("Updated")
                .build();
    }

    private JoinerEntity updateJoinerInfo(JoinerEntity joiner, JoinerRequest newJoinerInfo) {

        Long identificationNumber = newJoinerInfo.getIdentificationNumber();
        if(StringUtils.isNotBlank(String.valueOf(identificationNumber))) {
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
        if(StringUtils.isNotBlank(englishLevel)){
            joiner.setEnglishLevel(englishLevel);
        }

        String domainExperience = newJoinerInfo.getDomainExperience();
        if(StringUtils.isNotBlank(domainExperience)){
            joiner.setDomainExperience(domainExperience);
        }

        String stack = newJoinerInfo.getStack();
        if(StringUtils.isNotBlank(stack)) {
            joiner.setStack(stack);
        }

        return joiner;
    }
}
