package engineer.leepsky.javaintroonline.oop.oop1;

/* Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
вывести на консоль содержимое, дополнить, удалить. */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Textfile extends FObject {

    Textfile(Directory directory, String name) throws IOException {

        super(directory.getFile().getPath() + '/' + name);
        getFile().createNewFile();

    }

    public void print() throws IOException {

        String result = Files.readString(Path.of(getFile().getPath()));
        System.out.println(result);

    }

    public void append(String text) throws IOException {

        Files.write(Paths.get(getFile().getPath()), text.getBytes(), StandardOpenOption.APPEND);

    }

}
