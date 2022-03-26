package model;

import java.math.BigDecimal;
import java.util.LinkedList;

public class BankAccount {
    protected BigDecimal balance = BigDecimal.ZERO;
    protected LinkedList<AccountStatement> accountStatements = new LinkedList<>();

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LinkedList<AccountStatement> getAccountStatements() {
        return accountStatements;
    }
}
