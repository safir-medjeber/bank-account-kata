package services.interfaces;

import models.BankAccount;

public interface DepositOperations {
    void deposit(BankAccount account, int amount);
}
