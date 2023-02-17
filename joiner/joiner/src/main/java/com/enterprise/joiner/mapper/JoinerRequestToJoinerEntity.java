package com.enterprise.joiner.mapper;

import com.enterprise.joiner.model.dto.request.JoinerRequest;
import com.enterprise.joiner.model.entity.JoinerEntity;

public interface JoinerRequestToJoinerEntity {
    JoinerEntity map(JoinerRequest joinerRequest);
}
