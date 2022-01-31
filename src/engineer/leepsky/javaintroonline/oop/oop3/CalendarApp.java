package engineer.leepsky.javaintroonline.oop.oop3;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

/* Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
выходных и праздничных днях. */

public class CalendarApp {

    public static void main(String[] args) {

        Calendar myCalendar = new Calendar(DayOfWeek.SUNDAY);
        for (int i = 0; i < 15; i++) {
            System.out.println(myCalendar.getDay(i).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH) +
                               (myCalendar.getDay(i).isDayOff() ? " Rest" : " Work"));
        }

    }

}
