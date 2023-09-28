package com.example.backenddeveloperpracticaltest.service.impl;

import com.example.backenddeveloperpracticaltest.exceptionHendler.exception.NotFoundEntityException;
import com.example.backenddeveloperpracticaltest.models.entity.AccountEntity;
import com.example.backenddeveloperpracticaltest.models.entity.AuditEntity;
import com.example.backenddeveloperpracticaltest.repository.AuditRepository;
import com.example.backenddeveloperpracticaltest.service.interfaces.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class AuditServiceImplTest {
    private AuditServiceImpl auditService;
    @Mock
    private AuditRepository auditRepository;
    @Mock
    private AccountService accountService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        auditService = new AuditServiceImpl(auditRepository, accountService);
    }
    @Test
    public void testFindAllByAccount() {
        Long accountId = 1L;
        List<AuditEntity> auditList = new ArrayList<>();
        when(accountService.findById(accountId)).thenReturn(new AccountEntity());


        when(auditRepository.findAllByAccount(any(AccountEntity.class))).thenReturn(auditList);

        List<AuditEntity> result = auditService.findAllByAccount(accountId);

        assertSame(auditList, result);

        verify(accountService, times(1)).findById(accountId);

    }

    @Test
    public void testFindById() {
        Long auditId = 1L;
        AuditEntity auditEntity = new AuditEntity();
        when(auditRepository.findById(auditId)).thenReturn(Optional.of(auditEntity));

        AuditEntity result = auditService.findById(auditId);

        assertSame(auditEntity, result);
    }
    @Test
    public void testFindByIdNotFound() {

        Long auditId = 1L;
        when(auditRepository.findById(auditId)).thenReturn(Optional.empty());

        assertThrows(NotFoundEntityException.class, () -> auditService.findById(auditId));
    }

    @Test
    public void testSave() {

        AuditEntity auditEntity = new AuditEntity();

        auditService.save(auditEntity);

        verify(auditRepository, times(1)).save(auditEntity);
    }


}