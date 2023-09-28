package com.example.backenddeveloperpracticaltest.controller;


import com.example.backenddeveloperpracticaltest.models.dto.AuditDto;
import com.example.backenddeveloperpracticaltest.models.mapper.AuditMapper;
import com.example.backenddeveloperpracticaltest.service.interfaces.AuditService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts/{accountId}/transactions")
@Tag(name = "Транзакции", description = "методы для работы с транзакциями")
public class AuditController {

    private final AuditMapper mapper;
    private final AuditService service;

    @Operation(summary = "Получить все транзакции определённого аккаунта")
    @GetMapping
    public ResponseEntity<List<AuditDto>> getAllTransactions(@PathVariable Long accountId) {
        return ResponseEntity.ok(
                mapper.toDtoList(
                        service.findAllByAccount(accountId)));

    }

    @Operation(summary = "Получить транзакцию по ID")
    @GetMapping("/{auditId}")
    public ResponseEntity<AuditDto> getTransactionsById(@PathVariable Long auditId) {
        return ResponseEntity.ok(
                mapper.toDto(
                        service.findById(auditId)));

    }
}
