package com.example.backenddeveloperpracticaltest.exceptionHendler.exception;

public class DepositLessThanZeroException extends RuntimeException {
    public DepositLessThanZeroException(String message) {
        super(message);
    }
}
