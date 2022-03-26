package model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class AccountStatement {

    private final double currentBalance;
    private final BankOperationType bankOperationType;
    private final ZonedDateTime date;
    private final BigDecimal amount;

    public AccountStatement(BankOperationType bankOperationType, ZonedDateTime date, BigDecimal amount, double currentBalance) {
        this.bankOperationType = bankOperationType;
        this.date = date;
        this.amount = amount;
        this.currentBalance = currentBalance;
    }

    public BankOperationType getBankOperationType() {
        return bankOperationType;
    }

    public BigDecimal getAmount() {
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
