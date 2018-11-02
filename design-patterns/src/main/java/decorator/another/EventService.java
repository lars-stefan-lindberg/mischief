package decorator.another;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * Created by steflind on 2018-10-29.
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class EventService implements ServiceInterface {
    public void startService() {
        System.out.println("do something important here...");
    }
}
