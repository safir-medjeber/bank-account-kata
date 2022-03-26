import model.PersonalAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.AccountService;
import service.StatementService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountServiceTest {

    private AccountService accountService;

    @BeforeEach
    void before() {
        StatementService statementService = new StatementService();
        accountService = new AccountService(statementService);
    }

    @Test
    public void deposit_amount_should_increase_balance_account_with_amount() {
        var personalAccount = new PersonalAccount();

        accountService.deposit(personalAccount, BigDecimal.valueOf(10.50));

        assertEquals(10.50, personalAccount.getBalance());
    }

    @Test
    public void several_deposit_amount_should_increase_balance_account_with_amounts() {
        var personalAccount = new PersonalAccount();

        accountService.deposit(personalAccount, BigDecimal.valueOf(10));
        assertEquals(10, personalAccount.getBalance());

        accountService.deposit(personalAccount, BigDecimal.valueOf(20));
        assertEquals( 30, personalAccount.getBalance());
    }

    @Test
    void withdrawal_amount_should_decrease_balance_account_with_amount() {
        var personalAccount = new PersonalAccount();

        accountService.withdrawal(personalAccount, BigDecimal.valueOf(10.33));

        assertEquals(-10.33, personalAccount.getBalance());
    }

    @Test
    void several_withdrawal_amount_should_decrease_balance_account_with_amounts() {
        var account = new PersonalAccount();

        accountService.withdrawal(account, BigDecimal.valueOf(10.5));
        assertEquals(-10.5, account.getBalance());

        accountService.withdrawal(account, BigDecimal.valueOf(20.50));
        assertEquals(-31.0, account.getBalance());
    }
}
