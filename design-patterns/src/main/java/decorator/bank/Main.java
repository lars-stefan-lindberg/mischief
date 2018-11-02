package decorator.bank;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.io.IOException;

/**
 * Created by steflind on 2018-10-28.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        WithdrawalService ws = container.select(WithdrawalService.class).get();
        ws.startService();
    }
}
