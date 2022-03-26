import model.PersonalAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.AccountService;
import service.StatementService;

import java.math.BigDecimal;

import static model.BankOperationType.DEPOSIT;
import static model.BankOperationType.WITHDRAWAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StatetementServiceTest {

    private AccountService accountService;
    private StatementService statementService;

    @BeforeEach
    void before() {
        statementService = new StatementService();
        accountService = new AccountService(statementService);
    }

    @Test
    void deposit_should_update_account_statement() {
        var personalAccount = new PersonalAccount();

        accountService.deposit(personalAccount, BigDecimal.valueOf(10.33));

        var headAccountStatement = personalAccount.getAccountStatements().peek();
        assertNotNull(headAccountStatement);
        assertEquals(BigDecimal.valueOf(10.33).stripTrailingZeros(), headAccountStatement.getAmount().stripTrailingZeros());
        assertEquals(DEPOSIT, headAccountStatement.getBankOperationType());
    }

    @Test
    void withdrawal_should_update_account_statement() {
        var personalAccount = new PersonalAccount();

        accountService.withdrawal(personalAccount, BigDecimal.valueOf(10));

        var headAccountStatement = personalAccount.getAccountStatements().peek();
        assertNotNull(headAccountStatement);
        assertEquals(BigDecimal.valueOf(-10).stripTrailingZeros(), headAccountStatement.getAmount().stripTrailingZeros());
        assertEquals(WITHDRAWAL, headAccountStatement.getBankOperationType());
    }

    @Test
    public void test_print_account_statement() {
        var personalAccount = new PersonalAccount();
        accountService.deposit(personalAccount, BigDecimal.valueOf(10));
        accountService.deposit(personalAccount, BigDecimal.valueOf(10));
        String accountStatementExpected = personalAccount.getAccountStatements().toString();

        String accountStatementPrinted = statementService.printAccountStatement(personalAccount);

        assertEquals(accountStatementExpected, accountStatementPrinted);
    }
}
