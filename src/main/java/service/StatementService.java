package service;

import model.AccountStatement;
import model.BankAccount;

import java.time.ZonedDateTime;

public class StatementService implements BankStatementService {


    @Override
    public void updateAccountStatement(BankAccount account, double amount, String operation, ZonedDateTime zonedDateTime) {
        account.accountStatements.add(new AccountStatement(zonedDateTime, amount, operation));
    }

    @Override
    public void printAccountStatement(BankAccount bankAccount) {
        bankAccount.accountStatements.forEach(System.out::println);
    }


}
