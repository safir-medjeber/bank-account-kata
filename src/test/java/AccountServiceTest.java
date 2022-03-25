import model.PersonalAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.AccountService;
import service.StatementService;

import static model.BankOperationType.DEPOSIT;
import static model.BankOperationType.WITHDRAWAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AccountServiceTest {

    private AccountService accountService;
    private StatementService statementService;

    @BeforeEach
    void before() {
        statementService = new StatementService();
        accountService = new AccountService(statementService);
    }

    @Test
    public void deposit_amount_should_increase_balance_account_with_amount() {
        var account = new PersonalAccount();

        accountService.deposit(account, 10.50);

        assertEquals(10.50, account.getBalance());
    }

    @Test
    public void several_deposit_amount_should_increase_balance_account_with_amounts() {
        var account = new PersonalAccount();

        accountService.deposit(account, 10);
        assertEquals(10, account.getBalance());

        accountService.deposit(account, 20);
        assertEquals( 30, account.getBalance());
    }

    @Test
    void withdrawal_amount_should_decrease_balance_account_with_amount() {
        var personalAccount = new PersonalAccount();

        accountService.withdrawal(personalAccount, 10.33);

        assertEquals(-10.33, personalAccount.getBalance());
    }

    @Test
    void several_withdrawal_amount_should_decrease_balance_account_with_amounts() {
        var account = new PersonalAccount();

        accountService.withdrawal(account, 10.5);
        assertEquals(-10.5, account.getBalance());

        accountService.withdrawal(account, 20.50);
        assertEquals(-31.0, account.getBalance());
    }

    @Test
    void deposit_should_update_account_statement() {
        var personalAccount = new PersonalAccount();

        accountService.deposit(personalAccount, 10.33);

        var headAccountStatement = personalAccount.getAccountStatements().peek();
        assertNotNull(headAccountStatement);
        assertEquals(10.33, headAccountStatement.getAmount());
        assertEquals(DEPOSIT, headAccountStatement.getBankOperationType());
    }

    @Test
    void withdrawal_should_update_account_statement() {
        var personalAccount = new PersonalAccount();

        accountService.withdrawal(personalAccount, 10);

        var headAccountStatement = personalAccount.getAccountStatements().peek();
        assertNotNull(headAccountStatement);
        assertEquals(-10.0, headAccountStatement.getAmount());
        assertEquals(WITHDRAWAL, headAccountStatement.getBankOperationType());
    }

    @Test
    public void test_print_account_statement() {
        var personalAccount = new PersonalAccount();
        accountService.deposit(personalAccount, 10);
        accountService.deposit(personalAccount, 10);

        statementService.printAccountStatement(personalAccount);
    }
}
