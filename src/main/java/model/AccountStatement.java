package model;

import java.time.ZonedDateTime;

public class AccountStatement {

    public ZonedDateTime getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public String getOperation() {
        return operation;
    }

    private final ZonedDateTime date;
    private final int amount;
    private final String operation;

    public AccountStatement(ZonedDateTime date, int amount, String operation) {
        this.date = date;
        this.amount = amount;
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "AccountStatement{" +
                "date=" + date +
                ", amount=" + amount +
                ", operation='" + operation + '\'' +
                '}';
    }
}
