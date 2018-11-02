package decorator.bank;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * Created by steflind on 2018-10-30.
 */
@Decorator
public class SendSms implements WithdrawalCheck{

    @Any
    @Inject
    @Delegate
    private WithdrawalCheck withdrawalCheck;

    public void withdraw(double amount) {
        if(amount > 10000) {
            System.out.println(amount + " has been withdrawn from your account.");
            withdrawalCheck.withdraw(amount);
        }
    }
}
