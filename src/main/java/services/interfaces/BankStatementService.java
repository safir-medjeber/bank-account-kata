package services.interfaces;

import models.BankAccount;

import java.time.ZonedDateTime;

public interface BankStatementService {


     void updateAccountStatement(BankAccount account, int amount, String operation, ZonedDateTime zonedDateTime);

}
