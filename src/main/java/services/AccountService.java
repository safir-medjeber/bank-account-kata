package services;

import models.Account;
import models.AccountStatement;

import java.time.ZonedDateTime;

public class AccountService {

    public AccountService() {
    }

    public void deposit(Account account, int amount) {
        account.balance += amount;
        updateAccountStatement(account, amount, "deposit");
    }

    public void withdrawal(Account account, int amount) {
        account.balance -= amount;
        updateAccountStatement(account, Math.negateExact(amount) , "withdrawal");
    }

    private void updateAccountStatement(Account account, int amount, String operation) {
        account.accountStatements.add(new AccountStatement(ZonedDateTime.now(), amount, operation));
    }

}
