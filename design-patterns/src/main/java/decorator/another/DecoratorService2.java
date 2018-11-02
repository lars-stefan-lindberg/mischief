package decorator.another;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 * Created by steflind on 2018-10-29.
 */
@Decorator
public class DecoratorService2 implements ServiceInterface {

    @Inject
    @Delegate
    ServiceInterface service;

    public void startService() {
        System.out.println("decorating the service even further!!");
        service.startService();
    }
}
