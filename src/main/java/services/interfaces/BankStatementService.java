package services.interfaces;

import models.BankAccount;

public interface BankStatementService {


     void updateAccountStatement(BankAccount account, int amount, String operation);

}
