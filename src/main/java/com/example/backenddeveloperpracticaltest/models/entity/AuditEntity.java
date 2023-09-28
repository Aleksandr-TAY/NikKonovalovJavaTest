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
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Информация о транзакции")
public class AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Индификатор транзакции")
    long id;

    @ManyToOne
    @JsonBackReference
    @Schema(description = "Откуда перевод")
    AccountEntity account;

    @ManyToOne
    @JsonBackReference
    @Schema(description = "Куда перевод")
    AccountEntity accountReciever;
    @Schema(description = "Тип операции")
    String transationType;
    @Schema(description = "Сумма")
    BigDecimal value;


}
