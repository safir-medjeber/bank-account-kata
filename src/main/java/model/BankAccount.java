package model;

import java.util.LinkedList;

public class BankAccount {
    protected double balance;
    protected LinkedList<AccountStatement> accountStatements = new LinkedList<>();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LinkedList<AccountStatement> getAccountStatements() {
        return accountStatements;
    }
}
