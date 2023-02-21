package com.enterprise.joiner.service;

import com.enterprise.joiner.model.dto.request.JoinerRequest;
import com.enterprise.joiner.model.dto.response.JoinerResponse;

public interface JoinerService {

    JoinerResponse createJoiner(JoinerRequest joinerRequest);
    JoinerResponse updateJoiner(Long joinerId, JoinerRequest joinerRequest);
}
