package com.enterprise.joiner.controller;

import com.enterprise.joiner.model.dto.request.JoinerRequest;
import com.enterprise.joiner.model.dto.response.JoinerResponse;
import com.enterprise.joiner.service.JoinerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/joiners")
@RequiredArgsConstructor
public class JoinerController {
    private final JoinerService joinerService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getJoiner() {
        return "Hello Joiner";
    }
    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public JoinerResponse createJoiner(@Valid @RequestBody JoinerRequest joinerRequest) {
        return joinerService.createJoiner(joinerRequest);
    }

    @PutMapping(value = "/{joinerId}")
    @ResponseStatus(HttpStatus.OK)
    public JoinerResponse updateJoiner(@PathVariable Long joinerId, @RequestBody JoinerRequest joinerRequest) {
        return joinerService.updateJoiner(joinerId, joinerRequest);
    }
}
