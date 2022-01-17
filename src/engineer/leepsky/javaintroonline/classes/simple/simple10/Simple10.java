package engineer.leepsky.javaintroonline.classes.simple.simple10;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import engineer.leepsky.javaintroonline.classes.simple.simple6.Time;

public class Simple10 {

    /* Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
       и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
       методами. Задать критерии выбора данных и вывести эти данные на консоль.
       Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
       Найти и вывести:
       a) список рейсов для заданного пункта назначения;
       b) список рейсов для заданного дня недели;
       c) список рейсов для заданного дня недели, время вылета для которых больше заданного. */

    public static void printAirlineList(AirlineList myList) {
        for (Airline airline : myList) {
            System.out.println(airline);
        }
    }

    public static void main(String[] args) {

        AirlineList myList = new AirlineList();

        myList.add(
                new Airline("Moscow", 1217, 3, new Time(12, 30, 0),
                        new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.THURSDAY, DayOfWeek.SUNDAY)))
        );

        myList.add(
                new Airline("Minsk", 1219, 3, new Time(12, 40, 0),
                        new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.SUNDAY)))
        );

        myList.add(
                new Airline("Moscow", 1311, 2, new Time(13, 30, 0),
                        new ArrayList<>(List.of(DayOfWeek.THURSDAY)))
        );

        System.out.println("Full list:");
        printAirlineList(myList);

        System.out.println("\nList by destination (Moscow):");
        printAirlineList(myList.getFlightsByDestination("Moscow"));

        System.out.println("\nList by day of flight (Monday):");
        printAirlineList(myList.getFlightsByDay(DayOfWeek.MONDAY));

        System.out.println("\nList by dat and time (Thursday, 13:00):");
        printAirlineList(myList.getFlightsByDay(DayOfWeek.THURSDAY)
                               .getFlightByTime(new Time(13, 0, 0)));

    }

}
