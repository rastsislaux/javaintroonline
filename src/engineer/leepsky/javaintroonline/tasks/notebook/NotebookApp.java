package engineer.leepsky.javaintroonline.tasks.notebook;

/* Задание 2. Блокнот. Разработать консольное приложение, работающее с Заметками
в Блокноте. Каждая Заметка это: Заметка (тема, дата создания, e-mail, сообщение).
Общие пояснения к практическому заданию.
• В начале работы приложения данные должны считываться из файла, в конце
работы – сохраняться в файл.
• У пользователя должна быть возможность найти запись по любому параметру
или по группе параметров (группу параметров можно определить
самостоятельно), получить требуемые записи в отсортированном виде, найти
записи, текстовое поле которой содержит определенное слово, а также
добавить новую запись.
• Особое условие: поиск, сравнение и валидацию вводимой информации
осуществлять с использованием регулярных выражений.
• Особое условие: проверку введенной информации на валидность должен
осуществлять код, непосредственно добавляющий информацию. */

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class NotebookApp {

    private final static String WORK_DIR    =   "./src/engineer/leepsky/javaintroonline/tasks/notebook/";
    private final static String NOTES_PATH  =   WORK_DIR + "Notes.ser";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectFile notesFile = null;

        Notebook notebook;
        try {
            notesFile = new ObjectFile(NOTES_PATH, ObjectFile.Mode.READ);
            notebook = (Notebook) notesFile.readNext();
        } catch (EOFException | FileNotFoundException e) {
            notebook = new Notebook();
        }

        if (notesFile != null) {
            notesFile.close();
        }

        Scanner in = new Scanner(System.in);
        String command = "";

        while (!command.equals("exit")) {
            try {

                System.out.print("> ");
                command = in.next();

                switch (command) {

                    case "add" -> {
                        in.nextLine();
                        System.out.print("add > Enter theme: ");
                        String theme = in.nextLine();
                        System.out.print("add > Enter e-mail: ");
                        String email = in.nextLine();
                        System.out.print("add > Enter text: ");
                        String text = in.nextLine();
                        try {
                            notebook.add(new Note(theme, email, text));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    case "list" -> {
                        int i = 0;
                        for (Note note : notebook) {
                            Calendar tempCalendar = note.getDateOfCreation();
                            System.out.println(
                                    ++i + ". " + note.getTheme() +
                                    " (" + note.getEmail() + ") | " +
                                    tempCalendar.get(Calendar.DAY_OF_MONTH) + "." +
                                    tempCalendar.get(Calendar.MONTH) + "." +
                                    tempCalendar.get(Calendar.YEAR));
                        }
                    }

                    case "view" -> {
                        int index = in.nextInt();
                        try {
                            System.out.println(notebook.get(index - 1).getText());
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("view > There's no note numbered " + index + ".");
                        }
                    }

                    case "search" -> {
                        in.nextLine();
                        Notebook result = (Notebook) notebook.clone();

                        System.out.print("search > Date? (1/0): ");
                        if (in.nextInt() != 0) {
                            System.out.println("search > Month and day parameter can be ignored if zero-valued.");
                            System.out.print("search > Date (Y M D): ");
                            result = result.select(in.nextInt(), in.nextInt(), in.nextInt());
                        }

                        System.out.print("search > Theme? (1/0): ");
                        if (in.nextInt() != 0) {
                            System.out.print("search > Query: ");
                            in.nextLine();
                            result = result.select(in.nextLine(), Notebook.SelectMode.THEME);
                        }

                        System.out.print("search > Email? (1/0): ");
                        if (in.nextInt() != 0) {
                            System.out.print("search > Query: ");
                            in.nextLine();
                            result = result.select(in.nextLine(), Notebook.SelectMode.EMAIL);
                        }

                        System.out.print("search > Text? (1/0): ");
                        if (in.nextInt() != 0) {
                            System.out.print("search > Query: ");
                            in.nextLine();
                            result = result.select(in.nextLine(), Notebook.SelectMode.TEXT);
                        }

                        for (Note note : result) {
                            Calendar tempCalendar = note.getDateOfCreation();
                            System.out.println(
                                            notebook.indexOf(note) + 1 + ". " + note.getTheme() +
                                            " (" + note.getEmail() + ") | " +
                                            tempCalendar.get(Calendar.DAY_OF_MONTH) + "." +
                                            tempCalendar.get(Calendar.MONTH) + "." +
                                            tempCalendar.get(Calendar.YEAR));
                        }

                    }

                }

            } catch (InputMismatchException e) {
                System.out.println("Input mismatches. Try again!");
                in.nextLine();
            }
        }

        in.close();

        notesFile = new ObjectFile(NOTES_PATH, ObjectFile.Mode.WRITE);
        notesFile.writeNext(notebook);
        notesFile.close();

    }

}
