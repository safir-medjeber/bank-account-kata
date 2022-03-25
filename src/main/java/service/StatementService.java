package service;

import model.AccountStatement;
import model.BankAccount;
import model.BankOperationType;

import java.time.ZonedDateTime;

public class StatementService implements BankStatementService {


    @Override
    public void updateAccountStatement(BankAccount account, double amount, BankOperationType operation, ZonedDateTime zonedDateTime) {
        account.accountStatements.add(new AccountStatement(operation, zonedDateTime, amount));
    }

    @Override
    public void printAccountStatement(BankAccount bankAccount) {
        bankAccount.accountStatements.forEach(System.out::println);
    }


}
