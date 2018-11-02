package decorator.bank;

/**
 * Created by steflind on 2018-10-30.
 */
public class BankAccount implements WithdrawalCheck {

    private int balance = 100000;

    public void withdraw(double amount) {
        this.balance -= amount;
    }
}
