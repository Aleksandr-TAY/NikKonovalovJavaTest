package com.example.backenddeveloperpracticaltest.repository;

import com.example.backenddeveloperpracticaltest.models.entity.AccountEntity;
import com.example.backenddeveloperpracticaltest.models.entity.AccountNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountNumberRepository extends JpaRepository<AccountNumberEntity,Long> {
    Optional<AccountNumberEntity> getAccountNumberEntitiesByAccountNumber(String accountNumber);

    AccountEntity findFirstByAccount(AccountEntity accountEntity);
}
