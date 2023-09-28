package com.example.backenddeveloperpracticaltest.exceptionHendler.exception;

public class IncorrectPincodeException extends RuntimeException {
    public IncorrectPincodeException(String message) {
        super(message);
    }
}
