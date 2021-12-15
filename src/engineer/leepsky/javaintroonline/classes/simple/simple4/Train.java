package engineer.leepsky.javaintroonline.classes.simple.simple4;

import java.util.Arrays;

public class Train {

    /* Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
       Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
       номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
       Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
       назначения должны быть упорядочены по времени отправления. */

    private String destination;
    private int number, departureTime;

    Train(String destination, int number, int departureTime) {

        this.destination = destination;
        this.departureTime = departureTime;
        this.number = number;

    } 

    public String toString() {

        var buff = new StringBuilder();

        buff.append("Number: ")
            .append(number)
            .append(", destination: ")
            .append(destination)
            .append(", dep. time: ")
            .append(toTime(departureTime));

        return buff.toString();

    }

    public static String toTime(int seconds) {

        var buff = new StringBuilder();

        int hour    =   (int)(seconds / 3600);
        int minute  =   (int)((seconds - 3600 * hour) / 60);

        buff.append(hour)
            .append(":")
            .append(String.format("%02d", minute));

        return buff.toString();

    }

    public static void swapTrains(Train[] trains, int i, int j) {

        Train temp  = trains[i];
        trains[i] = trains[j];
        trains[j] = temp;

    }

    public static Train[] sortTrains(Train[] trains) {

        var result = Arrays.copyOf(trains, trains.length);

        for (int i = 0; i < result.length; i++)
            for (int j = i + 1; j < result.length; j++) {

                if ( result[i].destination.compareTo(result[j].destination) == 0 ) {

                    if ( result[i].departureTime > result[j].departureTime )
                        swapTrains(result, i, j);

                } else if ( result[i].destination.compareTo(result[j].destination) > 0 )
                    swapTrains(result, i, j);

            }

        return result;

    }

    public static int findTrainByNumber(Train[] trains, int number) {

        for (int i = 0; i < trains.length; i++)
            if (trains[i].number == number)
                return i;

        return -1;

    }
    
}
