package com.example.backenddeveloperpracticaltest.service.impl;
import com.example.backenddeveloperpracticaltest.exceptionHendler.exception.NotFoundEntityException;
import com.example.backenddeveloperpracticaltest.models.entity.AccountEntity;
import com.example.backenddeveloperpracticaltest.models.entity.AccountNumberEntity;
import com.example.backenddeveloperpracticaltest.repository.AccountRepositpry;
import com.example.backenddeveloperpracticaltest.service.interfaces.AccountNumberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountServiceImplTest {

    private AccountServiceImpl accountService;

    @Mock
    private AccountRepositpry accountRepository;

    @Mock
    private AccountNumberService accountNumberService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        accountService = new AccountServiceImpl(accountRepository, accountNumberService);
    }

    @Test
    public void testFindByAll() {
        List<AccountEntity> accountList = new ArrayList<>();
        when(accountRepository.findAll()).thenReturn(accountList);

        List<AccountEntity> result = accountService.findByAll();

        assertSame(accountList, result);
    }

    @Test
    public void testFindById() {
        Long accountId = 1L;
        AccountEntity accountEntity = new AccountEntity();
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(accountEntity));

        AccountEntity result = accountService.findById(accountId);

        assertSame(accountEntity, result);
    }

    @Test
    public void testFindByIdNotFound() {
        Long accountId = 1L;
        when(accountRepository.findById(accountId)).thenReturn(Optional.empty());

        assertThrows(NotFoundEntityException.class, () -> accountService.findById(accountId));
    }

    @Test
    public void testSaveEntityWithNewEntity() {
        AccountEntity accountEntity = new AccountEntity();
        when(accountRepository.findFirstByFirstNameAccountAndPinCode(
                accountEntity.getFirstNameAccount(), accountEntity.getPinCode())).thenReturn(null);

        when(accountNumberService.createEntity(any(AccountEntity.class))).thenReturn(new AccountNumberEntity());

        accountService.saveEntity(accountEntity);

        verify(accountRepository, times(1)).save(any(AccountEntity.class));
    }

    @Test
    public void testUpdateEntity() {
        AccountEntity accountEntity = new AccountEntity();

        accountService.updateEntity(accountEntity);

        verify(accountRepository, times(1)).save(accountEntity);
    }

    @Test
    public void testDeleteEntity() {
        Long accountId = 1L;

        accountService.deleteEntity(accountId);

        verify(accountRepository, times(1)).deleteById(accountId);
    }

    @Test
    public void testCreateEntity() {
        AccountEntity accountEntity = new AccountEntity();
        when(accountNumberService.createEntity(any(AccountEntity.class))).thenReturn(new AccountNumberEntity());

        AccountEntity result = accountService.createEntity(accountEntity);

        assertNotNull(result);
        assertNotNull(result.getAccountNumber());
    }

    @Test
    public void testCheckEntityWithNewEntity() {
        AccountEntity accountEntity = new AccountEntity();
        when(accountRepository.findFirstByFirstNameAccountAndPinCode(
                accountEntity.getFirstNameAccount(), accountEntity.getPinCode())).thenReturn(null);

        boolean result = accountService.checkEntity(accountEntity);

        assertTrue(result);
    }

    @Test
    public void testCheckEntityWithExistingEntity() {
        AccountEntity accountEntity = new AccountEntity();
        when(accountRepository.findFirstByFirstNameAccountAndPinCode(
                accountEntity.getFirstNameAccount(), accountEntity.getPinCode())).thenReturn(accountEntity);

        boolean result = accountService.checkEntity(accountEntity);

        assertFalse(result);
    }

}