package com.example.backenddeveloperpracticaltest.repository;

import com.example.backenddeveloperpracticaltest.models.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepositpry extends JpaRepository<AccountEntity,Long> {
    AccountEntity findFirstByFirstNameAccountAndPinCode(String firstNameAccount,String pinCode);


}
