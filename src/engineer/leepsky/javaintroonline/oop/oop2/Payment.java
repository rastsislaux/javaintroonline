package engineer.leepsky.javaintroonline.oop.oop2;

/* Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
нескольких товаров. */

import java.util.ArrayList;
import java.util.Arrays;

public class Payment {

    public record Entry(String productName, int price) { }

    private final ArrayList<Entry> entries = new ArrayList<>();

    public Payment(Entry... entries) {
        this.entries.addAll(Arrays.asList(entries));
    }

    public void printCheck() {

        int i = 0, sum = 0;
        for (Entry entry : entries) {
            System.out.println(++i + ". " + entry.productName() + ": " + entry.price() + "$");
            sum += entry.price();
        }
        System.out.println("Sum: " + sum);

    }

}
