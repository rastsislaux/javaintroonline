package engineer.leepsky.javaintroonline.oop.oop1;

/* Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
вывести на консоль содержимое, дополнить, удалить. */

import java.io.File;

public class FObject {

    private File file;

    public FObject(String path) {

        file = new File(path);

    }

    public FObject(FObject other) {

        file = new File(other.file.getPath());

    }

    public boolean rename(String newName) {

        File newFile = new File(file.getParent() + '/' + newName);
        boolean r = file.renameTo(newFile);
        this.file = newFile;
        return r;

    }

    public boolean delete() {
        boolean r = file.delete();
        file = null;
        return r;
    }

    public File getFile() {
        return file;
    }
}
