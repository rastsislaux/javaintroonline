package engineer.leepsky.javaintroonline.oop.oop1;

/* Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
вывести на консоль содержимое, дополнить, удалить. */

import java.io.IOException;

public class Directory extends FObject {

    Directory(String path) throws IOException {

        super(path);
        getFile().mkdirs();

    }

    Directory(Directory original) {

       super(original.getFile().getPath());

    }

}
