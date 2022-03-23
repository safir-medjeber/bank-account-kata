package models;

import java.util.LinkedList;

public class ClientAccount extends BankAccount {

    public ClientAccount() {
        balance = 0;
        accountStatements = new LinkedList<>();
    }

}
