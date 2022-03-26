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

        assertEquals(BigDecimal.valueOf(10.5).stripTrailingZeros(), personalAccount.getBalance().stripTrailingZeros());
    }

    @Test
    public void several_deposit_amount_should_increase_balance_account_with_amounts() {
        var personalAccount = new PersonalAccount();

        accountService.deposit(personalAccount, BigDecimal.valueOf(10));
        assertEquals(BigDecimal.valueOf(10).stripTrailingZeros(), personalAccount.getBalance().stripTrailingZeros());

        accountService.deposit(personalAccount, BigDecimal.valueOf(20));
        assertEquals( BigDecimal.valueOf(30).stripTrailingZeros(), personalAccount.getBalance().stripTrailingZeros());
    }

    @Test
    void withdrawal_amount_should_decrease_balance_account_with_amount() {
        var personalAccount = new PersonalAccount();

        accountService.withdrawal(personalAccount, BigDecimal.valueOf(10.33));

        assertEquals(BigDecimal.valueOf(-10.33).stripTrailingZeros(), personalAccount.getBalance().stripTrailingZeros());
    }

    @Test
    void several_withdrawal_amount_should_decrease_balance_account_with_amounts() {
        var account = new PersonalAccount();

        accountService.withdrawal(account, BigDecimal.valueOf(10.5));
        assertEquals(BigDecimal.valueOf(-10.5).stripTrailingZeros(), account.getBalance().stripTrailingZeros());

        accountService.withdrawal(account, BigDecimal.valueOf(20.50));
        assertEquals(BigDecimal.valueOf(-31.0).stripTrailingZeros(), account.getBalance().stripTrailingZeros());
    }
}
