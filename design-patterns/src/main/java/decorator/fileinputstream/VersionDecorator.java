package decorator.fileinputstream;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * Created by steflind on 2018-10-29.
 */
@Decorator
public class VersionDecorator implements Version {

    @Any
    @Inject
    @Delegate
    private Version version;

    public int getVersion() {
        return 0;
    }

    public void setVersion(int version) {

    }

    public int printVersion() {
        version.setVersion(version.getVersion() + 1);
        return version.printVersion();
    }
}
