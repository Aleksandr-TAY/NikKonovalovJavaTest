package com.example.backenddeveloperpracticaltest.controller;

import com.example.backenddeveloperpracticaltest.models.dto.AccountDto;
import com.example.backenddeveloperpracticaltest.models.mapper.AccountMapper;
import com.example.backenddeveloperpracticaltest.service.impl.AccountServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
@Tag(name = "Пользователи", description = "методы для работы с пользователями")
public class AccountController {

    private final AccountServiceImpl service;
    private final AccountMapper mapper;

    @Operation(summary = "Получить список всех аккаунтов")
    @GetMapping()
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return ResponseEntity.ok(mapper.toDtoList(service.findByAll()));
    }

    @Operation(summary = "Получить конкретный аккаунт по ID")
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.findById(id)));
    }

    @Operation(summary = "Создать новый аккаунт")
    @PostMapping
    public ResponseEntity<HttpStatus> createNewAccount(@Valid @RequestBody AccountDto accountDto) {
        service.saveEntity(mapper.toEntity(accountDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Изменить текущий аккаунт")
    @PutMapping
    public ResponseEntity<HttpStatus> updateAccount(@RequestBody AccountDto accountDto) {
        service.updateEntity(mapper.toEntity(accountDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Удалить аккаунт по ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAccountById(@PathVariable Long id) {
        service.deleteEntity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
