package engineer.leepsky.javaintroonline.oop.oop3;

/* Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
выходных и праздничных днях. */

import java.time.DayOfWeek;

public class Calendar {

    public static class Day {

        private final DayOfWeek dayOfWeek;
        private boolean isDayOff = false;

        private Day(DayOfWeek dayOfWeek, boolean isDayOff) {
            this.dayOfWeek = dayOfWeek;
            this.isDayOff = isDayOff;
        }

        public boolean isDayOff() {
            return isDayOff;
        }

        public void setDayOff(boolean isDayOff) {
            this.isDayOff = isDayOff;
        }

        public DayOfWeek getDayOfWeek() {
            return dayOfWeek;
        }
    }

    private Day[] days = new Day[365];

    Calendar(DayOfWeek firstDayOfWeek) {

        for (int i = 0; i < 365; i++) {
            days[i] = new Day(firstDayOfWeek, firstDayOfWeek.getValue() == 6 || firstDayOfWeek.getValue() == 7);
            firstDayOfWeek = firstDayOfWeek.plus(1);
        }

    }

    public Day getDay(int index) {
        return days[index];
    }

}
