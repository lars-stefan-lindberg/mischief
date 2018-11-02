package decorator.bank;

import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * Created by steflind on 2018-10-30.
 */
public class WithdrawalService {

    @Any
    @Inject
    WithdrawalCheck withdrawalCheck;

    public void startService() {
        withdrawalCheck.withdraw(1000);
        withdrawalCheck.withdraw(20000);
    }
}
