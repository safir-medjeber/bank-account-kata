package service;

import model.BankAccount;
import model.BankOperationType;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public interface BankStatementService {

     void updateAccountStatement(BankAccount account, BigDecimal amount, BankOperationType operation, ZonedDateTime zonedDateTime);

     void printAccountStatement(BankAccount bankAccount);
}
