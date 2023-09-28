package com.example.backenddeveloperpracticaltest.service.interfaces;

import com.example.backenddeveloperpracticaltest.models.entity.AccountEntity;

import java.util.List;

public interface AccountService {
    List<AccountEntity> findByAll();

    AccountEntity findById(Long id);

    void saveEntity(AccountEntity accountEntity );

    void updateEntity(AccountEntity accountEntity);

    void deleteEntity( Long id);

    AccountEntity createEntity(AccountEntity accountEntity);
    boolean checkEntity(AccountEntity accountEntity);

}
