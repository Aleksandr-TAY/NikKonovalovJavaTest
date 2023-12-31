package com.example.backenddeveloperpracticaltest.service.impl;

import com.example.backenddeveloperpracticaltest.models.entity.AccountEntity;
import com.example.backenddeveloperpracticaltest.models.entity.AccountNumberEntity;
import com.example.backenddeveloperpracticaltest.exceptionHendler.exception.NotFoundEntityException;
import com.example.backenddeveloperpracticaltest.models.entity.transaction.impl.Deposit;
import com.example.backenddeveloperpracticaltest.models.entity.transaction.impl.Transfer;
import com.example.backenddeveloperpracticaltest.models.entity.transaction.impl.Withdraw;
import com.example.backenddeveloperpracticaltest.repository.AccountNumberRepository;
import com.example.backenddeveloperpracticaltest.service.interfaces.AccountNumberService;
import com.example.backenddeveloperpracticaltest.service.interfaces.TransferService;
import com.example.backenddeveloperpracticaltest.service.interfaces.ValidationService;
import com.example.backenddeveloperpracticaltest.util.AutoGeneratedAccountNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountNumberServiceImpl implements AccountNumberService {

    private final AccountNumberRepository repository;
    private final TransferService transactionService;
    private final ValidationService validationService;
    private final AutoGeneratedAccountNumber generated;

    @Override
    public List<AccountNumberEntity> findByAll() {
        return repository.findAll();
    }

    @Override
    public AccountNumberEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException("Not found account with id = " + id));
    }

    @Override
    public AccountEntity findAccountByAccountNumber(AccountNumberEntity accountNumberEntity) {
        return repository.findFirstByAccount(accountNumberEntity.getAccount());
    }

    @Override
    @Transactional
    public AccountNumberEntity createEntity(AccountEntity accountEntity) {
        AccountNumberEntity.AccountNumberEntityBuilder builderAccountNumber = AccountNumberEntity.builder();
        builderAccountNumber.balance(BigDecimal.ZERO);
        builderAccountNumber.accountNumber(generated.getAccountNumber());
        builderAccountNumber.account(accountEntity);
        return builderAccountNumber.build();
    }

    @Override
    public AccountNumberEntity getAccountNumberEntity(String accountNumber) {
        return repository.getAccountNumberEntitiesByAccountNumber(accountNumber)
                .orElseThrow(() -> new NotFoundEntityException("Not found account with Account Number = " + accountNumber));
    }

    @Override
    @Transactional
    public void updateEntity(AccountNumberEntity accountNumberEntity) {
        repository.save(accountNumberEntity);
    }

    @Override
    @Transactional
    public void deleteEntity(AccountNumberEntity accountNumberEntity) {
        repository.delete(accountNumberEntity);
    }

    @Override
    @Transactional
    public void transferfromToMoney(Transfer transfer) {
        validationService.checkIfDepositAboveZero(transfer.getValue());
        AccountNumberEntity from = getAccountNumberEntity(transfer.getAccountNumber());
        validationService.checkPincode(from.getAccount().getPinCode(), transfer.getPinCode());
        AccountNumberEntity to = getAccountNumberEntity(transfer.getAccountReciever());
        transactionService.transfer(from, to, transfer.getValue());
        updateEntity(from);
        updateEntity(to);
    }

    @Override
    @Transactional
    public void withdrawalAcountNumber(Withdraw withdraw) {
        validationService.checkIfDepositAboveZero(withdraw.getValue());
        AccountNumberEntity from = getAccountNumberEntity(withdraw.getAccountNumber());
        validationService.checkPincode(from.getAccount().getPinCode(), withdraw.getPinCode());
        transactionService.withdrawal(from, withdraw.getValue());
        updateEntity(from);
    }

    @Override
    @Transactional
    public void deposit(Deposit deposit) {
        validationService.checkIfDepositAboveZero(deposit.getValue());
        AccountNumberEntity from = getAccountNumberEntity(deposit.getAccountNumber());
        validationService.checkPincode(from.getAccount().getPinCode(), deposit.getPinCode());
        transactionService.deposit(from, deposit.getValue());
        updateEntity(from);
    }


}
