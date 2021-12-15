package engineer.leepsky.javaintroonline.classes.simple.simple4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Simple4 {

    /* Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
       Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
       номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
       Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
       назначения должны быть упорядочены по времени отправления. */

    public static void main(String[] args) {

        var trains = new Train[] {

            new Train("Minsk", 1, 50400),
            new Train("Pinsk", 2, 50650),
            new Train("Pinsk", 3, 50400),
            new Train("Minsk", 4, 50340),
            new Train("Minsk", 5, 50460)

        };

        System.out.println("Original array:");
        for (var train : trains)
            System.out.println(train.toString());

        trains = Train.sortTrains(trains);

        System.out.println("Sorted array:");
        for (var train : trains)
            System.out.println(train.toString());

        int n = 1;
        Scanner in = new Scanner(System.in);

        while (true) {

            try {
                n = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Illegal input!");
                return;
            }

            if (n < 0) break;

            int index = Train.findTrainByNumber(trains, n);

            System.out.println(
                index != -1 ? trains[index].toString() : "No train with that number was found."
            );

        }

        in.close();

    }
    
}
