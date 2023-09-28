package com.example.backenddeveloperpracticaltest.models.dto;

import com.example.backenddeveloperpracticaltest.models.entity.AccountNumberEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AccountDto {
    Long id;

    List<AccountNumberEntity> accountNumber;

    String firstNameAccount;

    int pinCode;
}
