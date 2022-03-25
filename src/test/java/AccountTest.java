import model.ClientAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.AccountService;
import service.StatementService;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    private AccountService accountService;
    private StatementService statementService;

    @BeforeEach
    void before() {
        statementService = new StatementService();
        accountService = new AccountService(statementService);
    }

    @Test
    public void deposit_amount_should_increase_balance_account_with_amount() {
        ClientAccount account = new ClientAccount();
        double depositAmount = 10.50;
        double balanceAccountBeforeDeposit = account.balance;

        accountService.deposit(account, depositAmount);

        double currentBalanceAccount = account.balance;
        assertEquals(balanceAccountBeforeDeposit + depositAmount, currentBalanceAccount);
    }


    @Test
    public void several_deposit_amount_should_increase_balance_account_with_amounts() {
        ClientAccount account = new ClientAccount();
        double firstDepositAmount = 10;
        double secondDepositAmount = 20;

        double balanceAccountBeforeDeposit = account.balance;
        accountService.deposit(account, firstDepositAmount);
        double balanceAccountAfterFirstDeposit = account.balance;
        accountService.deposit(account, secondDepositAmount);
        double balanceAccountAfterSecondDeposit = account.balance;

        assertEquals(balanceAccountBeforeDeposit + firstDepositAmount, balanceAccountAfterFirstDeposit);
        assertEquals(balanceAccountAfterFirstDeposit + secondDepositAmount, balanceAccountAfterSecondDeposit);
    }


    @Test
    void withdrawal_amount_should_decrease_balance_account_with_amount() {
        ClientAccount account = new ClientAccount();
        double withdrawal = 10.33;
        double balanceAccountBeforeWithdrawal = account.balance;

        accountService.withdrawal(account, withdrawal);

        double currentBalanceAccount = account.balance;
        assertEquals(balanceAccountBeforeWithdrawal - withdrawal, currentBalanceAccount);
    }


    @Test
    void several_withdrawal_amount_should_decrease_balance_account_with_amounts() {
        ClientAccount account = new ClientAccount();

        double firstWithdrawalAmount = 10.5;
        double secondWithdrawalAmount = 20.50;

        double balanceAccountBeforeWithdrawal = account.balance;
        accountService.withdrawal(account, firstWithdrawalAmount);
        double balanceAccountAfterFirstWithdrawal = account.balance;
        accountService.withdrawal(account, secondWithdrawalAmount);
        double balanceAccountAfterSecondWithdrawal = account.balance;

        assertEquals(balanceAccountBeforeWithdrawal - firstWithdrawalAmount, balanceAccountAfterFirstWithdrawal);
        assertEquals(balanceAccountAfterFirstWithdrawal - secondWithdrawalAmount, balanceAccountAfterSecondWithdrawal);
    }

    @Test
    void deposit_should_update_account_statement() {

        ClientAccount clientAccount = new ClientAccount();
        accountService.deposit(clientAccount, 10.33);

        assertEquals(clientAccount.accountStatements.peek() != null ? clientAccount.accountStatements.peek().getAmount() : 0, 10.33);
        assertEquals(clientAccount.accountStatements.peek() != null ? clientAccount.accountStatements.peek().getOperation() : null, "deposit");


    }


    @Test
    void withdrawal_should_update_account_statement() {
        ClientAccount account = new ClientAccount();

        accountService.withdrawal(account, 10);

        assertEquals(-10.0, account.accountStatements.peek() != null ? account.accountStatements.peek().getAmount() : 0);
        assertEquals("withdrawal", account.accountStatements.peek() != null ? account.accountStatements.peek().getOperation() : null);

    }

    @Test
    public void test_prdouble_account_statement() {
        ClientAccount clientAccount = new ClientAccount();
        accountService.deposit(clientAccount, 10);
        accountService.deposit(clientAccount, 10);

        statementService.printAccountStatement(clientAccount);
    }
}
