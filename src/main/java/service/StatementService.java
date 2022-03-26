package service;

import model.AccountStatement;
import model.BankAccount;
import model.BankOperationType;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class StatementService implements BankStatementService {

    @Override
    public void updateAccountStatement(BankAccount bankAccount, BigDecimal amount, BankOperationType operation, ZonedDateTime zonedDateTime) {
        var accountStatement = new AccountStatement(operation, zonedDateTime, amount, bankAccount.getBalance());
        bankAccount.getAccountStatements().add(accountStatement);
    }

    @Override
    public void printAccountStatement(BankAccount bankAccount) {
        bankAccount.getAccountStatements().forEach(System.out::println);
    }
}
