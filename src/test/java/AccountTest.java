import models.ClientAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.AccountService;
import services.StatementService;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    private AccountService accountService;

    @BeforeEach
    void before() {
        StatementService statementService = new StatementService();
        accountService = new AccountService(statementService);
    }

    @Test
    public void deposit_amount_should_increase_balance_account_with_amount() {
        ClientAccount account = new ClientAccount();
        int depositAmount = 10;
        int balanceAccountBeforeDeposit = account.balance;

        accountService.deposit(account, depositAmount);
        int currentBalanceAccount = account.balance;

        assertEquals(balanceAccountBeforeDeposit + depositAmount, currentBalanceAccount);
    }


    @Test
    public void several_deposit_amount_should_increase_balance_account_with_amounts() {
        ClientAccount account = new ClientAccount();


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
        ClientAccount account = new ClientAccount();
        int withdrawal = 10;
        int balanceAccountBeforeWithdrawal = account.balance;

        accountService.withdrawal(account, withdrawal);
        int currentBalanceAccount = account.balance;

        assertEquals(balanceAccountBeforeWithdrawal - withdrawal, currentBalanceAccount);
    }


    @Test
    void several_withdrawal_amount_should_decrease_balance_account_with_amounts() {
        ClientAccount account = new ClientAccount();

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

        ClientAccount account = new ClientAccount();
        accountService.deposit(account, 10);

        assertEquals(account.accountStatements.peek() != null ? account.accountStatements.peek().amount : 0, 10);
        assertEquals(account.accountStatements.peek() != null ? account.accountStatements.peek().operation : null, "deposit");


    }


    @Test
    void withdrawal_should_update_account_statement() {
        ClientAccount account = new ClientAccount();

        accountService.withdrawal(account, 10);

        assertEquals(-10.0, account.accountStatements.peek() != null ? account.accountStatements.peek().amount : 0);
        assertEquals("withdrawal", account.accountStatements.peek() != null ? account.accountStatements.peek().operation : null);


    }


}
