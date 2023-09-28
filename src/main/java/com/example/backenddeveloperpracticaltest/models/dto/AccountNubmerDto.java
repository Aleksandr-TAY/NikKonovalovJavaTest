package com.example.backenddeveloperpracticaltest.models.dto;

import com.example.backenddeveloperpracticaltest.models.entity.AccountEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AccountNubmerDto {

    Long id;

    AccountEntity account;

    BigDecimal balance;

    String accountNumber;
}
