package service;

import model.BankAccount;

public interface WithdrawalOperations {

    void withdrawal(BankAccount account, double amount);

}
