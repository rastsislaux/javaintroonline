package engineer.leepsky.javaintroonline.tasks.notebook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ObjectFile {

    private final String path;
    private ObjectInputStream ois = null;
    private ObjectOutputStream oos = null;

    enum Mode {
        WRITE,
        READ
    }

    ObjectFile(String path, Mode mode) throws IOException {
        this.path = path;
        if (mode == Mode.WRITE) {
            oos = getObjectOutputStream();
        } else {
            ois = getObjectInputStream();
        }
    }

    private ObjectOutputStream getObjectOutputStream() throws IOException {

        if (!Files.exists(Path.of(path)))
            Files.createFile(Path.of(path));

        return new ObjectOutputStream(new FileOutputStream(path));

    }

    private ObjectInputStream getObjectInputStream() throws IOException {

        return new ObjectInputStream(new FileInputStream(path));

    }

    public Object readNext() throws IOException, ClassNotFoundException {

        if (ois != null) {
            return ois.readObject();
        }
        return new Object();

    }

    public void writeNext(Object obj) throws IOException {

        if (oos != null) {
            oos.writeObject(obj);
        }

    }

    public void close() throws IOException {

        if (oos != null) {
            oos.flush();
            oos.close();
        } else {
            ois.close();
        }

    }

}
