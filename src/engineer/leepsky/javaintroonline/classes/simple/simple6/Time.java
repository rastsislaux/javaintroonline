package engineer.leepsky.javaintroonline.classes.simple.simple6;

public class Time {

    /* Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
       изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
       недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
       заданное количество часов, минут и секунд. */

    private static final int DEFAULT_VALUE = 0;

    private int hour, minute, second;

    Time(int hour, int minute, int second) {

        if (hour > 24 || hour < 0)
            this.hour = DEFAULT_VALUE;
        else
            this.hour = hour;

        if (minute > 60 || minute < 0)
            this.minute = DEFAULT_VALUE;
        else
            this.minute = minute;

        if (second > 60 || second < 0)
            this.second = DEFAULT_VALUE;
        else
            this.second = second;

    }

    public void setHour(int hour) {

        if (hour > 24 || hour < 0)
            this.hour = DEFAULT_VALUE;
        else
            this.hour = hour;

    }

    public void setMinute(int minute) {

        if (minute > 60 || minute < 0)
            this.minute = DEFAULT_VALUE;
        else
            this.minute = minute;

    }

    public void setSecond(int second) {

        if (second > 60 || second < 0)
            this.second = DEFAULT_VALUE;
        else
            this.second = second;

    }

    public void addHours(int hours) {

        this.hour = (this.hour + hours) % 24;

    }

    public void addMinutes(int minutes) {

        minutes = this.minute + minutes;
        int hours = minutes / 60;
        minutes = minutes - hours * 60;
        this.minute = minutes;
        addHours(hours);

    }

    public void addSeconds(int seconds) {

        seconds = this.second + seconds;
        int minutes = seconds / 60;
        seconds = seconds - minutes * 60;
        this.second = seconds;
        addMinutes(minutes);

    }

    public String toString() {

        return String.format("%02d:%02d:%02d", hour, minute, second);

    }

}
