package com.example.backenddeveloperpracticaltest.models.entity.transaction.impl;

import com.example.backenddeveloperpracticaltest.models.entity.transaction.interfaces.Transactions;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Deposit implements Transactions {
    @Pattern(regexp = "[0-9]{12}", message = "Incorrect account mask")
    private String accountNumber;
    @Min(value = 0, message = "Transaction value can't be less than zero")
    private BigDecimal value;
    @Pattern(regexp = "[0-9]{4}", message = "Incorrect Pincode Type")
    private String pinCode;

}
