package service;

import model.BankAccount;

import java.time.ZonedDateTime;


public class AccountService implements DepositOperations, WithdrawalOperations {
    BankStatementService bankStatementService;

    public AccountService(BankStatementService bankStatementService) {
        this.bankStatementService = bankStatementService;
    }

    public void deposit(BankAccount bankAccount, double amount) {
        bankAccount.balance += amount;
        this.bankStatementService.updateAccountStatement(bankAccount, amount, "deposit", ZonedDateTime.now());
    }

    public void withdrawal(BankAccount bankAccount, double amount) {
        bankAccount.balance -= amount;
        this.bankStatementService.updateAccountStatement(bankAccount, getNegativeAmount(amount) , "withdrawal",ZonedDateTime.now() );
    }

    private double getNegativeAmount(double amount) {
    return -amount;
    }

}
