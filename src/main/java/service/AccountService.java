package service;

import model.BankAccount;

import java.time.ZonedDateTime;

import static model.BankOperationType.DEPOSIT;
import static model.BankOperationType.WITHDRAWAL;


public class AccountService implements DepositOperations, WithdrawalOperations {
    BankStatementService bankStatementService;

    public AccountService(BankStatementService bankStatementService) {
        this.bankStatementService = bankStatementService;
    }

    public void deposit(BankAccount bankAccount, double amount) {
        bankAccount.setBalance(bankAccount.getBalance() + amount);
        this.bankStatementService.updateAccountStatement(bankAccount, amount, DEPOSIT, ZonedDateTime.now());
    }

    public void withdrawal(BankAccount bankAccount, double amount) {
        bankAccount.setBalance(bankAccount.getBalance() - amount);
        this.bankStatementService.updateAccountStatement(bankAccount, getNegativeAmount(amount) , WITHDRAWAL,ZonedDateTime.now());
    }

    private double getNegativeAmount(double amount) {
    return -amount;
    }

}
