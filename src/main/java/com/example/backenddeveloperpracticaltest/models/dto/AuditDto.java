package com.example.backenddeveloperpracticaltest.models.dto;

import com.example.backenddeveloperpracticaltest.models.entity.AccountEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuditDto {

    long id;

    AccountEntity account;

    AccountEntity accountReciever;

    String transationType;

    BigDecimal value;
}
