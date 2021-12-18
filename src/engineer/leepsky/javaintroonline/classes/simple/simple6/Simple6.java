package engineer.leepsky.javaintroonline.classes.simple.simple6;

import java.util.concurrent.Flow.Subscriber;

public class Simple6 {

    /* Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
       изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
       недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
       заданное количество часов, минут и секунд. */

    public static void main(String[] args) {

        Time myTime = new Time(12, 30, 30); // Time constructor with proper args.
        System.out.println(
            myTime.toString()
        );

        myTime.addHours(4); // Add a little hours.
        System.out.println(
            myTime.toString()
        );

        myTime.addHours(10); // Add a lot of hours, hour doesn't exceed 24.
        System.out.println(
            myTime.toString()
        );

        myTime.addMinutes(125); // Add 2 hours and 5 minutes.
        System.out.println(
            myTime.toString()
        );

        myTime.addSeconds(3600 + 1800 + 10); // Add 1 hour, 30 minutes and 10 seconds.
        System.out.println(
            myTime.toString()
        );

        myTime = new Time(25, 61, 61);

        System.out.println(
            myTime.toString()
        );

        myTime.setHour(12);
        myTime.setMinute(30);
        myTime.setSecond(30);

        System.out.println(
            myTime.toString()
        );

        myTime.setHour(25);
        myTime.setMinute(61);
        myTime.setSecond(61);

        System.out.println(
            myTime.toString()
        );

    }
    
}
