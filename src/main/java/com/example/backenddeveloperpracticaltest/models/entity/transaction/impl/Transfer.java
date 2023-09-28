package com.example.backenddeveloperpracticaltest.models.entity.transaction.impl;

import com.example.backenddeveloperpracticaltest.models.entity.transaction.interfaces.Transactions;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Transfer extends Withdraw implements Transactions {
    @Pattern(regexp = "[0-9]{12}", message = "Incorrect account mask")
    private String accountReciever;

}
