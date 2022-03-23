package services;

import models.AccountStatement;
import models.BankAccount;
import services.interfaces.BankStatementService;

import java.time.ZonedDateTime;

public class StatementService implements BankStatementService {


    @Override
    public void updateAccountStatement(BankAccount account, int amount, String operation) {
        account.accountStatements.add(new AccountStatement(ZonedDateTime.now(), amount, operation));

    }
}
