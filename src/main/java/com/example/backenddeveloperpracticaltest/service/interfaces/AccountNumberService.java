package com.example.backenddeveloperpracticaltest.service.interfaces;

import com.example.backenddeveloperpracticaltest.models.entity.AccountEntity;
import com.example.backenddeveloperpracticaltest.models.entity.AccountNumberEntity;
import com.example.backenddeveloperpracticaltest.models.entity.transaction.impl.Deposit;
import com.example.backenddeveloperpracticaltest.models.entity.transaction.impl.Transfer;
import com.example.backenddeveloperpracticaltest.models.entity.transaction.impl.Withdraw;

import java.util.List;

public interface AccountNumberService {

    List<AccountNumberEntity> findByAll();

    AccountNumberEntity findById(Long id);

    AccountEntity findAccountByAccountNumber(AccountNumberEntity accountNumberEntity);

    AccountNumberEntity createEntity(AccountEntity accountEntity);
    AccountNumberEntity getAccountNumberEntity(String accountNumber);
    void deleteEntity(AccountNumberEntity accountNumberEntity);

    void updateEntity(AccountNumberEntity accountNumberEntity);

    void transferfromToMoney(Transfer transfer);

    void withdrawalAcountNumber(Withdraw withdraw);

    void deposit(Deposit deposit);


}
