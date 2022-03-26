package service;

import model.BankAccount;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import static model.BankOperationType.DEPOSIT;
import static model.BankOperationType.WITHDRAWAL;

public class AccountService implements DepositOperations, WithdrawalOperations {
    BankStatementService bankStatementService;

    public AccountService(BankStatementService bankStatementService) {
        this.bankStatementService = bankStatementService;
    }

    public void deposit(BankAccount bankAccount, BigDecimal amount) {
        bankAccount.setBalance(bankAccount.getBalance() + amount.doubleValue());
        this.bankStatementService.updateAccountStatement(bankAccount, amount, DEPOSIT, ZonedDateTime.now());
    }

    public void withdrawal(BankAccount bankAccount, BigDecimal amount) {
        bankAccount.setBalance(bankAccount.getBalance() - amount.doubleValue());
        this.bankStatementService.updateAccountStatement(bankAccount, amount.negate() , WITHDRAWAL,ZonedDateTime.now());
    }
}
