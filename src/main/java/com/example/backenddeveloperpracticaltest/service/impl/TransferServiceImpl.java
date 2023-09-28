package com.example.backenddeveloperpracticaltest.service.impl;

import com.example.backenddeveloperpracticaltest.models.entity.AccountNumberEntity;
import com.example.backenddeveloperpracticaltest.service.interfaces.TransferService;
import com.example.backenddeveloperpracticaltest.service.interfaces.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {
    private final ValidationService service;


    @Override
    public void transfer(AccountNumberEntity from, AccountNumberEntity to, BigDecimal money) {
        service.checkBalance(from.getBalance(),money);
        from.setBalance(from.getBalance().subtract(money));
        to.setBalance(to.getBalance().add(money));
    }

    @Override
    public void withdrawal(AccountNumberEntity from, BigDecimal money) {
        service.checkBalance(from.getBalance(),money);
        from.setBalance(from.getBalance().subtract(money));
    }

    @Override
    public void deposit(AccountNumberEntity from, BigDecimal money) {
        from.setBalance(from.getBalance().add(money));
    }
}
