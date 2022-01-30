package engineer.leepsky.javaintroonline.oop.oop1;

/* Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
вывести на консоль содержимое, дополнить, удалить. */

import java.io.IOException;

public class FileApplication {

    public static void main(String[] args) {

        try {

            Textfile myFile = new Textfile(
                    new Directory("./src/engineer/leepsky/javaintroonline/oop/oop1"),
                    "file.txt"
            );

            myFile.append("Some text in a file.");
            myFile.print();
            myFile.rename("file2.txt");
            myFile.append("\nNew text in a file.");
            myFile.print();
            myFile.delete();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
