package service;

import model.BankAccount;

import java.time.ZonedDateTime;


public class AccountService implements DepositOperations, WithdrawalOperations {
    BankStatementService bankStatementService;

    public AccountService(BankStatementService bankStatementService) {
        this.bankStatementService = bankStatementService;
    }

    public void deposit(BankAccount account, double amount) {
        account.balance += amount;
        this.bankStatementService.updateAccountStatement(account, amount, "deposit", ZonedDateTime.now());
    }

    public void withdrawal(BankAccount account, double amount) {
        account.balance -= amount;
        this.bankStatementService.updateAccountStatement(account, getNegativeAmount(amount) , "withdrawal",ZonedDateTime.now() );
    }

    private double getNegativeAmount(double amount) {
    return -amount;
    }

}
