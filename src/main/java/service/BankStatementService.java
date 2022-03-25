package service;

import model.BankAccount;

import java.time.ZonedDateTime;

public interface BankStatementService {


     void updateAccountStatement(BankAccount account, double amount, String operation, ZonedDateTime zonedDateTime);

     void printAccountStatement(BankAccount bankAccount);
}
