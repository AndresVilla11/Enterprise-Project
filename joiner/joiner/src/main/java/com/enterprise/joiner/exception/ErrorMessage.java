package com.enterprise.joiner.exception;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ErrorMessage {
    private final String exception;
    private final String message;
    private final String path;

    public ErrorMessage(Exception exception, String path) {
        this.message = exception.getMessage();
        this.exception = exception.getClass().getSimpleName();
        this.path = path;
    }
}