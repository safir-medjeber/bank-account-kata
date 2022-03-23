package models;

import java.util.LinkedList;
import java.util.Queue;

public class Account {

    public int balance;
    public Queue<AccountStatement> accountStatements;


    public Account() {
        balance = 0;
        accountStatements = new LinkedList<AccountStatement>();
    }

}
