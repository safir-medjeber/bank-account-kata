package service;

import model.BankAccount;

public interface DepositOperations {
    void deposit(BankAccount account, double amount);
}
