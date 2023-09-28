package com.example.backenddeveloperpracticaltest.exceptionHendler.exception;

public class NotFoundEntityException extends RuntimeException {
    public NotFoundEntityException(String message) {
        super(message);
    }
}
