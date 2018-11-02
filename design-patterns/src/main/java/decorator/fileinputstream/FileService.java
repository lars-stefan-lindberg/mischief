package decorator.fileinputstream;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * Created by steflind on 2018-10-29.
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class FileService {

    @Any
    @Inject
    Version version;

    public void startService() {
        System.out.println(version.printVersion());
    }

}
