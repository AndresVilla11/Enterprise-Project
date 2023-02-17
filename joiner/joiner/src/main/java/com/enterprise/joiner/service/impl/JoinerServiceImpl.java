package com.enterprise.joiner.service.impl;

import com.enterprise.joiner.mapper.JoinerRequestToJoinerEntity;
import com.enterprise.joiner.mapper.impl.JoinerRequestToJoinerEntityImpl;
import com.enterprise.joiner.model.dto.request.JoinerRequest;
import com.enterprise.joiner.model.dto.response.JoinerResponse;
import com.enterprise.joiner.model.entity.JoinerEntity;
import com.enterprise.joiner.repository.JoinerRepository;
import com.enterprise.joiner.service.JoinerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinerServiceImpl implements JoinerService {
    private final JoinerRepository joinerRepository;

    @Override
    public JoinerResponse createJoiner(JoinerRequest joinerRequest) {
        return JoinerResponse.builder().build();
    }
}
