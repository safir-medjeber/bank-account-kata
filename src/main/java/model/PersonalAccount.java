package model;

import java.util.LinkedList;

public class PersonalAccount extends BankAccount {

    public PersonalAccount() {
        balance = 0;
        accountStatements = new LinkedList<>();
    }
}
