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
}
