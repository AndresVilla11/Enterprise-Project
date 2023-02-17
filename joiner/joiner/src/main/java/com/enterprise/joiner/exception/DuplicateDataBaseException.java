package com.enterprise.joiner.exception;

public class DuplicateDataBaseException extends RuntimeException {
    private static final String DESCRIPTION = "Duplicate data in database ";

    public DuplicateDataBaseException(String details) {
        super(DESCRIPTION + details);
    }
}
