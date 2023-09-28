package com.example.backenddeveloperpracticaltest.service.impl;

import com.example.backenddeveloperpracticaltest.exceptionHendler.exception.NotFoundEntityException;
import com.example.backenddeveloperpracticaltest.models.entity.AuditEntity;
import com.example.backenddeveloperpracticaltest.repository.AuditRepository;
import com.example.backenddeveloperpracticaltest.service.interfaces.AccountService;
import com.example.backenddeveloperpracticaltest.service.interfaces.AuditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {
    private final AuditRepository repository;
    private final AccountService service;

    @Override
    public List<AuditEntity> findAllByAccount(Long accountId) {
        return repository.findAllByAccount(service.findById(accountId));
    }

    @Override
    public AuditEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException("Not found transfer with id = " + id));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(AuditEntity auditEntity) {
        repository.save(auditEntity);
    }
}
