package engineer.leepsky.javaintroonline.oop.oop4;

/* Создать консольное приложение, удовлетворяющее следующим требованиям:
• Приложение должно быть объектно-, а не процедурно-ориентированным.
• Каждый класс должен иметь отражающее смысл название и информативный состав.
• Наследование должно применяться только тогда, когда это имеет смысл.
• При кодировании должны быть использованы соглашения об оформлении кода java code convention.
• Классы должны быть грамотно разложены по пакетам.
• Консольное меню должно быть минимальным.
• Для хранения данных можно использовать файлы.
Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и
выбора сокровищ на заданную сумму. */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TreasuresApp {

    public static void main(String[] args) {

        TreasureList tList = new TreasureList();

        try {

            Scanner fin = new Scanner(new File("./src/engineer/leepsky/javaintroonline/oop/oop4/treasureFile.txt"));
            while (fin.hasNext()) {
                String tName = fin.next();
                int tWeight = fin.nextInt(),
                    tCost = fin.nextInt();
                tList.add(new Treasure(tName, tWeight, tCost));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("""
                Menu:
                \t1. Print all treasures
                \t2. Print the most valuable treasure
                \t3. Print treasures for some cost
                Enter mode:""");

        Scanner in = new Scanner(System.in);

        try {

            int mode = in.nextInt();
            switch (mode) {
                case 1 -> System.out.println(tList);
                case 2 -> System.out.println(tList.getMostExpensive());
                case 3 -> {
                    System.out.print("Enter cost: ");
                    int cost = in.nextInt();
                    int i = 0;
                    for (Treasure treasure : tList.getListByCost(cost)) {
                        System.out.println(++i + ". " + treasure.getName() + ", weight: " +
                                treasure.getWeight() + ", cost: " + treasure.getCost());
                    }
                }
            }

        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

    }

}
