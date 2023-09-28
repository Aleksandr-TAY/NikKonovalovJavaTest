package com.example.backenddeveloperpracticaltest.service.impl;

import com.example.backenddeveloperpracticaltest.models.entity.AccountNumberEntity;
import com.example.backenddeveloperpracticaltest.service.interfaces.ValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransferServiceImplTest {
    private TransferServiceImpl transferService;

    @Mock
    private ValidationService<TransferServiceImpl> validationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        transferService = new TransferServiceImpl(validationService);
    }

    @Test
    void Testtransfer() {
        AccountNumberEntity from = new AccountNumberEntity();
        from.setBalance(BigDecimal.valueOf(100));

        AccountNumberEntity to = new AccountNumberEntity();
        to.setBalance(BigDecimal.valueOf(50));

        BigDecimal money = BigDecimal.valueOf(25);
        transferService.transfer(from, to, money);
        assertEquals(BigDecimal.valueOf(75), from.getBalance());
        assertEquals(BigDecimal.valueOf(75), to.getBalance());


    }

    @Test
    void withdrawal() {
        AccountNumberEntity from = new AccountNumberEntity();
        from.setBalance(BigDecimal.valueOf(100));

        BigDecimal money = BigDecimal.valueOf(70);

        transferService.withdrawal(from, money);

        assertEquals(BigDecimal.valueOf(30), from.getBalance());


    }

    @Test
    void deposit() {
        AccountNumberEntity account = new AccountNumberEntity();
        account.setBalance(BigDecimal.valueOf(100));

        BigDecimal money = BigDecimal.valueOf(50);

        // Act
        transferService.deposit(account, money);

        // Assert
        assertEquals(BigDecimal.valueOf(150), account.getBalance());

    }
}