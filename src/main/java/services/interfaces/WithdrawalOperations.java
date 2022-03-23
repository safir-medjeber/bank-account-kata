package services.interfaces;

import models.BankAccount;

public interface WithdrawalOperations {

    void withdrawal(BankAccount account, int amount);

}
