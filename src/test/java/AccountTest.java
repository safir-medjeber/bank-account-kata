import models.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.AccountService;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {


    private AccountService accountService;

    @BeforeEach
            void before(){
        accountService = new AccountService();
    }

    @Test
    public void deposit_amount_should_increase_balance_account_with_amount() {
        Account account = new Account();
        int depositAmount = 10;
        int balanceAccountBeforeDeposit = account.balance;

        accountService.deposit(account, depositAmount);
        int currentBalanceAccount = account.balance;

        assertEquals(balanceAccountBeforeDeposit + depositAmount, currentBalanceAccount);
    }


    @Test
    public void several_deposit_amount_should_increase_balance_account_with_amounts() {
        Account account = new Account();


        int firstDepositAmount = 10;
        int secondDepositAmount = 20;

        int balanceAccountBeforeDeposit = account.balance;
        accountService.deposit(account, firstDepositAmount);
        int balanceAccountAfterFirstDeposit = account.balance;
        accountService.deposit(account, secondDepositAmount);
        int balanceAccountAfterSecondDeposit = account.balance;

        assertEquals(balanceAccountBeforeDeposit + firstDepositAmount, balanceAccountAfterFirstDeposit);
        assertEquals(balanceAccountAfterFirstDeposit + secondDepositAmount, balanceAccountAfterSecondDeposit);
    }


    @Test
     void withdrawal_amount_should_decrease_balance_account_with_amount() {
        Account account = new Account();
        int withdrawal = 10;
        int balanceAccountBeforeWithdrawal = account.balance;

        accountService.withdrawal(account, withdrawal);
        int currentBalanceAccount = account.balance;

        assertEquals(balanceAccountBeforeWithdrawal - withdrawal, currentBalanceAccount);
    }


    @Test
     void several_withdrawal_amount_should_decrease_balance_account_with_amounts() {
        Account account = new Account();

        int firstWithdrawalAmount = 10;
        int secondWithdrawalAmount = 20;

        int balanceAccountBeforeWithdrawal = account.balance;
        accountService.withdrawal(account, firstWithdrawalAmount);
        int balanceAccountAfterFirstWithdrawal = account.balance;
        accountService.withdrawal(account, secondWithdrawalAmount);
        int balanceAccountAfterSecondWithdrawal = account.balance;

        assertEquals(balanceAccountBeforeWithdrawal - firstWithdrawalAmount, balanceAccountAfterFirstWithdrawal);
        assertEquals(balanceAccountAfterFirstWithdrawal - secondWithdrawalAmount, balanceAccountAfterSecondWithdrawal);
    }

    @Test
     void deposit_should_update_account_statement() {

        Account account = new Account();
        accountService.deposit(account, 10);

        assertEquals(account.accountStatements.peek().amount, 10);
        assertEquals(account.accountStatements.peek().operation, "deposit");


    }


    @Test
     void withdrawal_should_update_account_statement() {
        Account account = new Account();

        accountService.withdrawal(account, 10);

        assertEquals(-10.0, account.accountStatements.peek().amount);
        assertEquals("withdrawal", account.accountStatements.peek().operation);


    }


}
