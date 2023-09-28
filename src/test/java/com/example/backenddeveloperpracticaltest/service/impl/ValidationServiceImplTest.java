package com.example.backenddeveloperpracticaltest.service.impl;

import com.example.backenddeveloperpracticaltest.exceptionHendler.exception.BalanceException;
import com.example.backenddeveloperpracticaltest.exceptionHendler.exception.DepositLessThanZeroException;
import com.example.backenddeveloperpracticaltest.exceptionHendler.exception.IncorrectPincodeException;
import com.example.backenddeveloperpracticaltest.models.entity.AccountEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ValidationServiceImplTest {
    @InjectMocks
    private ValidationServiceImpl<AccountEntity> service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDepositLessThanZeroException() {
        BigDecimal value = new BigDecimal(-1);
        assertThrows(DepositLessThanZeroException.class, () -> service.checkIfDepositAboveZero(value));
    }

    @Test
    void testCheckPincode() {
        String pinCode = "1234";
        String check = "1111";
        assertThrows(IncorrectPincodeException.class, () -> service.checkPincode(pinCode, check));
    }

    @Test
    void testCheckBalance() {
        BigDecimal check = new BigDecimal(20);
        BigDecimal controll = new BigDecimal(30);
        assertThrows(BalanceException.class, () -> service.checkBalance(check,controll));
    }
}