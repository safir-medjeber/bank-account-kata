package model;

import java.time.ZonedDateTime;

public class AccountStatement {

    private final double currentBalance;
    private final BankOperationType bankOperationType;
    private final ZonedDateTime date;
    private final double amount;

    public AccountStatement(BankOperationType bankOperationType, ZonedDateTime date, double amount, double currentBalance) {
        this.bankOperationType = bankOperationType;
        this.date = date;
        this.amount = amount;
        this.currentBalance = currentBalance;
    }

    public BankOperationType getBankOperationType() {
        return bankOperationType;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "AccountStatement{" +
                "bankOperationType=" + bankOperationType +
                ", date=" + date +
                ", amount=" + amount +
                ", balance=" + currentBalance +
                '}';
    }
}
