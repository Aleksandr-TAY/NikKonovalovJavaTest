package com.example.backenddeveloperpracticaltest.models.entity.transaction.impl;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountCreating {
    @NotBlank(message = "There is no valid name")
    private String AccountName;
    @Pattern(regexp = "[0-9]{4}", message = "Incorrect Pincode Type")
    private String pincode;

}
