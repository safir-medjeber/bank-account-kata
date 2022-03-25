import model.BankOperationType;
import model.PersonalAccount;
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
        PersonalAccount account = new PersonalAccount();
        double depositAmount = 10.50;
        double balanceAccountBeforeDeposit = account.balance;

        accountService.deposit(account, depositAmount);

        double currentBalanceAccount = account.balance;
        assertEquals(balanceAccountBeforeDeposit + depositAmount, currentBalanceAccount);
    }


    @Test
    public void several_deposit_amount_should_increase_balance_account_with_amounts() {
        PersonalAccount account = new PersonalAccount();
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
        PersonalAccount account = new PersonalAccount();
        double withdrawal = 10.33;
        double balanceAccountBeforeWithdrawal = account.balance;

        accountService.withdrawal(account, withdrawal);

        double currentBalanceAccount = account.balance;
        assertEquals(balanceAccountBeforeWithdrawal - withdrawal, currentBalanceAccount);
    }


    @Test
    void several_withdrawal_amount_should_decrease_balance_account_with_amounts() {
        PersonalAccount account = new PersonalAccount();

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

        PersonalAccount personalAccount = new PersonalAccount();
        accountService.deposit(personalAccount, 10.33);

        assertEquals(10.33, personalAccount.accountStatements.peek() != null ? personalAccount.accountStatements.peek().getAmount() : 0);
        assertEquals(BankOperationType.DEPOSIT, personalAccount.accountStatements.peek() != null ? personalAccount.accountStatements.peek().getBankOperationType() : null);


    }


    @Test
    void withdrawal_should_update_account_statement() {
        PersonalAccount account = new PersonalAccount();

        accountService.withdrawal(account, 10);

        assertEquals(-10.0, account.accountStatements.peek() != null ? account.accountStatements.peek().getAmount() : 0);
        assertEquals(BankOperationType.WITHDRAWAL, account.accountStatements.peek() != null ? account.accountStatements.peek().getBankOperationType() : null);

    }

    @Test
    public void test_prdouble_account_statement() {
        PersonalAccount personalAccount = new PersonalAccount();
        accountService.deposit(personalAccount, 10);
        accountService.deposit(personalAccount, 10);

        statementService.printAccountStatement(personalAccount);
    }
}
