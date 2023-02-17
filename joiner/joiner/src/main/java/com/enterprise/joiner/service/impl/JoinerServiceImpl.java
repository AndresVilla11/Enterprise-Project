package com.enterprise.joiner.service.impl;

import com.enterprise.joiner.model.dto.request.JoinerRequest;
import com.enterprise.joiner.model.dto.response.JoinerResponse;
import com.enterprise.joiner.model.entity.JoinerEntity;
import com.enterprise.joiner.repository.JoinerRepository;
import com.enterprise.joiner.service.JoinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class JoinerServiceImpl implements JoinerService {
    @Autowired
    JoinerRepository joinerRepository;
    @Override
    public JoinerResponse updateJoiner(Long joinerId, JoinerRequest newJoinerInfo) {
        System.out.println("update joiner service");
       JoinerEntity joiner = Optional.of(joinerRepository.findById(joinerId))
               .get()
               .orElseThrow(() -> new NoSuchElementException("Joiner with id: " + joinerId + " not found."));



        System.out.println("Joiner updated " + joiner);
        return null;
    }
}
