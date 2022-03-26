package service;

import model.BankAccount;

import java.math.BigDecimal;

public interface WithdrawalOperations {

    void withdrawal(BankAccount bankAccount, BigDecimal amount);
}
