package com.example.backenddeveloperpracticaltest.auditAspect;

import com.example.backenddeveloperpracticaltest.models.dto.AuditDto;
import com.example.backenddeveloperpracticaltest.models.entity.transaction.impl.Deposit;
import com.example.backenddeveloperpracticaltest.models.entity.transaction.impl.Transfer;
import com.example.backenddeveloperpracticaltest.models.entity.transaction.impl.Withdraw;
import com.example.backenddeveloperpracticaltest.models.mapper.AuditMapper;
import com.example.backenddeveloperpracticaltest.service.interfaces.AccountNumberService;
import com.example.backenddeveloperpracticaltest.service.interfaces.AuditService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
@RequiredArgsConstructor
public class AuditAspect {
    private final AuditService service;
    private final AuditMapper mapper;
    private final AccountNumberService accountNumberService;


    @AfterReturning("execution(* transferfromToMoney(*)) && args(transfer)")
    public void afterCreate(Transfer transfer) throws JsonProcessingException {
        AuditDto.AuditDtoBuilder builder = AuditDto.builder();
        builder.value(transfer.getValue());
        builder.account(accountNumberService.getAccountNumberEntity(transfer.getAccountNumber()).getAccount());
        builder.accountReciever(accountNumberService.getAccountNumberEntity(transfer.getAccountReciever()).getAccount());
        builder.transationType("Transfer");
        service.save(mapper.toEntity(builder.build()));
    }
    @AfterReturning("execution(* withdrawalAcountNumber(*)) && args(withdraw)")
    public void afterCreate(Withdraw withdraw) throws JsonProcessingException {
        AuditDto.AuditDtoBuilder builder = AuditDto.builder();
        builder.value(withdraw.getValue());
        builder.account(accountNumberService.getAccountNumberEntity(withdraw.getAccountNumber()).getAccount());
        builder.transationType("Withdraw");
        service.save(mapper.toEntity(builder.build()));
    }
    @AfterReturning("execution(* deposit(*)) && args(deposit)")
    public void afterCreate(Deposit deposit) throws JsonProcessingException {
        AuditDto.AuditDtoBuilder builder = AuditDto.builder();
        builder.value(deposit.getValue());
        builder.account(accountNumberService.getAccountNumberEntity(deposit.getAccountNumber()).getAccount());
        builder.transationType("Deposit");
        service.save(mapper.toEntity(builder.build()));
    }


}
