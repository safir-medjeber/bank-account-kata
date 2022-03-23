import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    Account account = new Account();

    @Test
    public void deposit_amount_should_increase_balance_account_with_amount() {
        int depositAmount = 10;
        int balanceAccountBeforeDeposit = account.balance;

        account.deposit(depositAmount);
        int currentBalanceAccount =  account.balance;

        assertEquals(balanceAccountBeforeDeposit + depositAmount, currentBalanceAccount);
    }


    @Test
    public void several_deposit_amount_should_increase_balance_account_with_amounts() {
        int firstDepositAmount = 10;
        int secondDepositAmount = 20;

        int balanceAccountBeforeDeposit = account.balance;
        account.deposit(firstDepositAmount);
        int balanceAccountAfterFirstDeposit =  account.balance;
        account.deposit(secondDepositAmount);
        int balanceAccountAfterSecondDeposit =  account.balance;

        assertEquals(balanceAccountBeforeDeposit + firstDepositAmount, balanceAccountAfterFirstDeposit);
        assertEquals(balanceAccountAfterFirstDeposit + secondDepositAmount, balanceAccountAfterSecondDeposit);
    }


    @Test
    public void withdrawal_amount_should_decrease_balance_account_with_amount() {
        int withdrawal = 10;
        int balanceAccountBeforeWithdrawal = account.balance;

        account.withdrawal(withdrawal);
        int currentBalanceAccount =  account.balance;

        assertEquals(balanceAccountBeforeWithdrawal - withdrawal, currentBalanceAccount);
    }


    @Test
    public void several_withdrawal_amount_should_decrease_balance_account_with_amounts() {
        int firstWithdrawalAmount = 10;
        int secondWithdrawalAmount = 20;

        int balanceAccountBeforeWithdrawal = account.balance;
        account.withdrawal(firstWithdrawalAmount);
        int balanceAccountAfterFirstWithdrawal =  account.balance;
        account.withdrawal(secondWithdrawalAmount);
        int balanceAccountAfterSecondWithdrawal =  account.balance;

        assertEquals(balanceAccountBeforeWithdrawal - firstWithdrawalAmount, balanceAccountAfterFirstWithdrawal);
        assertEquals(balanceAccountAfterFirstWithdrawal - secondWithdrawalAmount, balanceAccountAfterSecondWithdrawal);
    }


}
