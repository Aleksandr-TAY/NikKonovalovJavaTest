package com.example.backenddeveloperpracticaltest.service.interfaces;

import java.math.BigDecimal;

public interface ValidationService<T> {
    void checkPincode(String control, String pincode);
    void checkIfDepositAboveZero(BigDecimal deposit);

    void checkBalance(BigDecimal value,BigDecimal money);

}
