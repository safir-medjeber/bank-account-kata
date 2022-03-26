package service;

import model.BankAccount;

import java.math.BigDecimal;

public interface DepositOperations {
    void deposit(BankAccount bankAccount, BigDecimal amount);
}
