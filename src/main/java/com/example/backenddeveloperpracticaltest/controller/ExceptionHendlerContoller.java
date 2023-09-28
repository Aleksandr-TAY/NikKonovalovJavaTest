package com.example.backenddeveloperpracticaltest.controller;

import com.example.backenddeveloperpracticaltest.exceptionHendler.ErrorMessage;
import com.example.backenddeveloperpracticaltest.exceptionHendler.exception.BalanceException;
import com.example.backenddeveloperpracticaltest.exceptionHendler.exception.DepositLessThanZeroException;
import com.example.backenddeveloperpracticaltest.exceptionHendler.exception.IncorrectPincodeException;
import com.example.backenddeveloperpracticaltest.exceptionHendler.exception.NotFoundEntityException;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Tag(name = "Исключения", description = "виды исключений")
public class ExceptionHendlerContoller {
    @ExceptionHandler(NotFoundEntityException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> notFoundEntityExceptionHandller() {
        return new ResponseEntity<>(new ErrorMessage(HttpStatus.NOT_FOUND.value(),
                "Element hasn't been found in DB"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DepositLessThanZeroException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> depositLessThenZeroExceptionHandller() {
        return new ResponseEntity<>(new ErrorMessage(HttpStatus.NOT_FOUND.value(),
                "Deposit can't be less than zero"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IncorrectPincodeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> incorrectPincodeExceptionHandller() {
        return new ResponseEntity<>(new ErrorMessage(HttpStatus.NOT_FOUND.value(),
                "Incorrect pincode"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BalanceException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> balanceExceptionHendler() {
        return new ResponseEntity<>(new ErrorMessage(HttpStatus.NOT_FOUND.value(),
                "not enough money on the balance"), HttpStatus.NOT_FOUND);
    }

}
