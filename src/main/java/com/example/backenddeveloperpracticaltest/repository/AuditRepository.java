package com.example.backenddeveloperpracticaltest.repository;

import com.example.backenddeveloperpracticaltest.models.entity.AccountEntity;
import com.example.backenddeveloperpracticaltest.models.entity.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditRepository extends JpaRepository<AuditEntity,Long> {
    List<AuditEntity> findAllByAccount(AccountEntity accountEntity);
}
