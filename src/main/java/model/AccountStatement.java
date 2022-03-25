package model;

import java.time.ZonedDateTime;

public class AccountStatement {

    public ZonedDateTime getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }


    private final ZonedDateTime date;
    private final double amount;

    public BankOperationType getBankOperationType() {
        return bankOperationType;
    }

    private final BankOperationType bankOperationType;

    public AccountStatement(BankOperationType bankOperationType, ZonedDateTime date, double amount) {
        this.bankOperationType = bankOperationType;
        this.date = date;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AccountStatement{" +
                "date=" + date +
                ", amount=" + amount +
                ", operation='" + bankOperationType + '\'' +
                '}';
    }
}
