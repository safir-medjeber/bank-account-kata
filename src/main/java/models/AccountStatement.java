package models;

import java.time.ZonedDateTime;

public class AccountStatement {

    public ZonedDateTime date;
    public int amount;
   public String operation;

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
