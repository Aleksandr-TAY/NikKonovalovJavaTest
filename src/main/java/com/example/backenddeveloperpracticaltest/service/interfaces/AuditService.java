package com.example.backenddeveloperpracticaltest.service.interfaces;


import com.example.backenddeveloperpracticaltest.models.entity.AuditEntity;

import java.util.List;

public interface AuditService {
    List<AuditEntity> findAllByAccount(Long accountId);

    AuditEntity findById(Long id);

    void save(AuditEntity auditEntity);

}
