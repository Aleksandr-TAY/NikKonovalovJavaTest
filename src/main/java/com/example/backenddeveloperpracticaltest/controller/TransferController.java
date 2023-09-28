package com.example.backenddeveloperpracticaltest.controller;


import com.example.backenddeveloperpracticaltest.models.entity.transaction.impl.Deposit;
import com.example.backenddeveloperpracticaltest.models.entity.transaction.impl.Transfer;
import com.example.backenddeveloperpracticaltest.models.entity.transaction.impl.Withdraw;
import com.example.backenddeveloperpracticaltest.service.interfaces.AccountNumberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/accounts/{accountId}/transfer")
@RequiredArgsConstructor
@Tag(name = "Счет пользователя", description = "методы для работы с счетом пользователя")
public class TransferController {
    private final AccountNumberService service;


    @Operation(summary = "Пополнение счёта")
    @PutMapping("/deposit")
    public ResponseEntity<HttpStatus> addDepositTransaction(@Valid @RequestBody Deposit deposit) {
        service.deposit(deposit);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Списание со счёта")
    @PutMapping("/withdraw")
    public ResponseEntity<HttpStatus> addWithdrawTransaction(@Valid @RequestBody Withdraw withdraw) {
        service.withdrawalAcountNumber(withdraw);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Перевод с одного счёта на другой")
    @PutMapping("/transfer")
    public ResponseEntity<HttpStatus> addTransferTransaction(@Valid @RequestBody Transfer transfer) {
        service.transferfromToMoney(transfer);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
