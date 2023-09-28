package com.example.backenddeveloperpracticaltest.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Schema(description = "Информация об счете")
public class AccountNumberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Schema(description = "Индификатор счета")
    Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "account_Id")
    @Schema(description = "Инормация владельца счета")
    AccountEntity account;
    @Schema(description = "Баланс")
    BigDecimal balance;
    @Schema(description = "Номер счета")
    String accountNumber;

}
