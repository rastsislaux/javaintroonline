package engineer.leepsky.javaintroonline.tasks.notebook;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class Notebook extends ArrayList<Note> {

    enum SelectMode {
        THEME,
        EMAIL,
        TEXT
    }

    public Notebook select(String query, SelectMode mode) {
        Notebook notebook = new Notebook();
        Pattern pattern = Pattern.compile(query);
        for (Note note : this) {
            Matcher matcher;
            switch (mode) {
                case TEXT   -> matcher = pattern.matcher(note.getText());
                case THEME  -> matcher = pattern.matcher(note.getTheme());
                default     -> matcher = pattern.matcher(note.getEmail());
            }
            if (matcher.find()) {
                notebook.add(note);
            }
        }
        return notebook;
    }

    public Notebook select(int year, int month, int day) {
        Notebook notebook = new Notebook();
        for (Note note : this) {
            if (
                    note.getDateOfCreation().get(Calendar.YEAR) == year &&
                    (note.getDateOfCreation().get(Calendar.MONTH) == month || month == 0) &&
                    (note.getDateOfCreation().get(Calendar.DAY_OF_MONTH) == day || day == 0)
            ) {
                notebook.add(note);
            }

        }
        return notebook;
    }

}
