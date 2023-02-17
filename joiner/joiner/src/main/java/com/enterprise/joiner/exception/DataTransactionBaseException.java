package com.enterprise.joiner.exception;

import org.springframework.transaction.TransactionSystemException;

public class DataTransactionBaseException extends TransactionSystemException {
    private static final String DESCRIPTION = "Error transactional, query did not execute for transaction ";

    public DataTransactionBaseException(String msg) {
        super(DESCRIPTION + msg);
    }
}
