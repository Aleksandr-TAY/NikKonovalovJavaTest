package com.example.backenddeveloperpracticaltest.service.impl;

import com.example.backenddeveloperpracticaltest.models.entity.AccountEntity;
import com.example.backenddeveloperpracticaltest.exceptionHendler.exception.NotFoundEntityException;
import com.example.backenddeveloperpracticaltest.models.entity.AccountNumberEntity;
import com.example.backenddeveloperpracticaltest.repository.AccountRepositpry;
import com.example.backenddeveloperpracticaltest.service.interfaces.AccountNumberService;
import com.example.backenddeveloperpracticaltest.service.interfaces.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepositpry repository;
    private final AccountNumberService accountNumberService;

    @Override
    public List<AccountEntity> findByAll() {
        return repository.findAll();
    }

    @Override
    public AccountEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException("Not found account with id = " + id));
    }

    @Override
    @Transactional
    public void saveEntity(AccountEntity accountEntity) {
        AccountEntity createAccountEntity = new AccountEntity();
        if(checkEntity(accountEntity)){
            createAccountEntity=createEntity(accountEntity);
        }else {
            createAccountEntity=repository.findFirstByFirstNameAccountAndPinCode(
                    accountEntity.getFirstNameAccount(),accountEntity.getPinCode());
            createAccountEntity.getAccountNumber().add(accountNumberService.createEntity(createAccountEntity));
        }
        repository.save(createAccountEntity);
    }

    @Override
    @Transactional
    public void updateEntity(AccountEntity accountEntity) {
        repository.save(accountEntity);
    }

    @Override
    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    @Override
    public AccountEntity createEntity(AccountEntity accountEntity) {
        AccountEntity createAccountEntity = new AccountEntity();
        List<AccountNumberEntity> list = new ArrayList<>();
        list.add(accountNumberService.createEntity(createAccountEntity));
        createAccountEntity.setFirstNameAccount(accountEntity.getFirstNameAccount());
        createAccountEntity.setPinCode(accountEntity.getPinCode());
        createAccountEntity.setAccountNumber(list);
        return createAccountEntity;
    }

    @Override
    public boolean checkEntity(AccountEntity accountEntity) {
        AccountEntity chek= repository.findFirstByFirstNameAccountAndPinCode(
                accountEntity.getFirstNameAccount(),accountEntity.getPinCode());
        return chek == null;
    }

}
