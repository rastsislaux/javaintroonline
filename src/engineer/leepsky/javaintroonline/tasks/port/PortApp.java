package engineer.leepsky.javaintroonline.tasks.port;

/* Корабли заходят в порт для
разгрузки/загрузки контейнеров. Число контейнеров, находящихся в текущий момент
в порту и на корабле, должно быть неотрицательным и превышающим заданную
грузоподъемность судна и вместимость порта. В порту работает несколько причалов.
У одного причала может стоять один корабль. Корабль может загружаться у причала
или разгружаться. */

import java.util.InputMismatchException;
import java.util.Scanner;

public class PortApp {

    public static void main(String[] args) {

        Port port = new Port(5000, 10000);
        Scanner in = new Scanner(System.in);
        int command = 1;

        System.out.println("Команды:\n\t0 - Закончить выполнение программы\n\t1 - Добавить корабль");
        try {
            while (command != 0) {
                command = in.nextInt();

                switch (command) {
                    case 0 -> System.out.println("Завершение.");
                    case 1 -> {
                        System.out.print("Введите количество контейнеров и вместимость корабля:");
                        try {
                            port.addShip(new Ship(in.nextInt(), in.nextInt()));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    default -> System.out.println("Неизвестная команда.");
                }

            }
        } catch (InputMismatchException e) {
            System.out.println("Неверный ввод: вводите только целые числа.");
        }

    }

}
