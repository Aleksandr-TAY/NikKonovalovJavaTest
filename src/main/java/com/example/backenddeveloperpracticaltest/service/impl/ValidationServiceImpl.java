package com.example.backenddeveloperpracticaltest.service.impl;

import com.example.backenddeveloperpracticaltest.exceptionHendler.exception.BalanceException;
import com.example.backenddeveloperpracticaltest.exceptionHendler.exception.DepositLessThanZeroException;
import com.example.backenddeveloperpracticaltest.exceptionHendler.exception.IncorrectPincodeException;
import com.example.backenddeveloperpracticaltest.service.interfaces.ValidationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ValidationServiceImpl<T> implements ValidationService<T> {
    @Override
    public void checkPincode(String control, String pincode) {
        if (!control.equals(pincode)) throw new IncorrectPincodeException("incorrect pincode");
    }

    @Override
    public void checkIfDepositAboveZero(BigDecimal deposit) {
        if (deposit.compareTo(BigDecimal.ZERO) < 0) throw new DepositLessThanZeroException("negative deposit");
    }

    @Override
    public void checkBalance(BigDecimal value,BigDecimal money) {
        if(value.compareTo(money)<0) throw new BalanceException("not enough money on the balance");

    }
}
