package com.example.backenddeveloperpracticaltest.models.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Schema(description = "Информация об аккаунте")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Schema(description = "индификатор аккаунта")
    Long id;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
    @JsonManagedReference
    @Schema(description = "Счета аккаунта")
    List<AccountNumberEntity> accountNumber;

    @Schema(description = "Имя аккаунта")
    String firstNameAccount;
    @Schema(description = "Пин код")
    String pinCode;

}
