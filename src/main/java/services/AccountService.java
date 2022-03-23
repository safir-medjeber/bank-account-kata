package services;

import models.BankAccount;
import services.interfaces.BankStatementService;
import services.interfaces.DepositOperations;
import services.interfaces.WithdrawalOperations;
import java.time.ZonedDateTime;


public class AccountService implements DepositOperations, WithdrawalOperations {
    BankStatementService bankStatementService;

    public AccountService(BankStatementService bankStatementService) {
        this.bankStatementService = bankStatementService;
    }

    public void deposit(BankAccount account, int amount) {
        account.balance += amount;
        this.bankStatementService.updateAccountStatement(account, amount, "deposit", ZonedDateTime.now());
    }

    public void withdrawal(BankAccount account, int amount) {
        account.balance -= amount;
        this.bankStatementService.updateAccountStatement(account, Math.negateExact(amount) , "withdrawal",ZonedDateTime.now() );
    }

}
