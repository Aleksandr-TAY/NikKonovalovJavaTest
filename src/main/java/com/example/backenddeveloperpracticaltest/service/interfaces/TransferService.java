package com.example.backenddeveloperpracticaltest.service.interfaces;

import com.example.backenddeveloperpracticaltest.models.entity.AccountNumberEntity;

import java.math.BigDecimal;

public interface TransferService {
    void transfer(AccountNumberEntity from, AccountNumberEntity to, BigDecimal money);

    void withdrawal(AccountNumberEntity accountNumberEntity, BigDecimal money);

    void deposit(AccountNumberEntity accountNumberEntity, BigDecimal money);
}
