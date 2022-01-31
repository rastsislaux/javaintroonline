package engineer.leepsky.javaintroonline.oop.oop4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

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

public class TreasureList implements Iterable<Treasure> {

    ArrayList<Treasure> treasureList = new ArrayList<>();

    public void add(Treasure treasure) {
        treasureList.add(treasure);
    }

    public Treasure get(int index) {
        return treasureList.get(index);
    }

    public Treasure getMostExpensive() {
        Treasure result = new Treasure("NOT_FOUND", -1, -1);
        for (Treasure treasure : treasureList) {
            if ( result.getCost() < treasure.getCost() ) {
                result = treasure;
            }
        }
        return result;
    }

    public TreasureList getListByCost(int cost) {

        int newCost = 0;
        TreasureList treasures = new TreasureList();
        for (Treasure treasure : treasureList) {
            if (newCost + treasure.getCost() < cost) {
                treasures.add(treasure);
                newCost += treasure.getCost();
            }
        }
        return treasures;

    }

    public Iterator<Treasure> iterator() { return treasureList.iterator(); }

    public void remove(int index) {
        treasureList.remove(index);
    }

    public void remove(Treasure treasure) {
        treasureList.remove(treasure);
    }

    @Override
    public String toString() {
        return "TreasureList{" +
                treasureList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreasureList that = (TreasureList) o;
        return Objects.equals(treasureList, that.treasureList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(treasureList);
    }

}
