package decorator.fileinputstream;

import decorator.another.EventService;
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
        FileService fs = container.select(FileService.class).get();
        fs.startService();
    }
}
