package decorator.fileinputstream;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by steflind on 2018-10-29.
 */
public class FileInputStreamMod extends FileInputStream implements Version {

    private int version = 1;

    public FileInputStreamMod(String name) throws FileNotFoundException {
        super(name);
    }

    public FileInputStreamMod(File file) throws FileNotFoundException {
        super(file);
    }

    public FileInputStreamMod(FileDescriptor fdObj) {
        super(fdObj);
    }


    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int printVersion() {
        return version;
    }
}
