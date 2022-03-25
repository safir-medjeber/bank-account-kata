package service;

import model.BankAccount;

public interface WithdrawalOperations {

    void withdrawal(BankAccount bankAccount, double amount);

}
