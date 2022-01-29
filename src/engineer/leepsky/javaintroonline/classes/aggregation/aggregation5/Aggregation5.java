package engineer.leepsky.javaintroonline.classes.aggregation.aggregation5;

/* Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок. */

import java.util.ArrayList;
import java.util.Arrays;

public class Aggregation5 {

    public static void main(String[] args) {

        TourList tourList = new TourList(new ArrayList<>(Arrays.asList(
                new Tour(Tour.Type.REST, Tour.Transport.BUS, Tour.Food.FULL, 14),
                new Tour(Tour.Type.EXCURSION, Tour.Transport.PLANE, Tour.Food.ONCE, 7),
                new Tour(Tour.Type.TREATMENT, Tour.Transport.NO, Tour.Food.NO, 21),
                new Tour(Tour.Type.SHOPPING, Tour.Transport.BUS, Tour.Food.TWICE, 28),
                new Tour(Tour.Type.CRUISE, Tour.Transport.LINER, Tour.Food.FULL, 4)
        )));

        System.out.println("Before sorting:");
        tourList.print();

        System.out.println("After sorting:");
        tourList.sortByLength();
        tourList.print();

        System.out.println("Select tours by type (rest):");
        tourList.select(Tour.Type.REST).print();

        System.out.println("Select tours by food (full):");
        tourList.select(Tour.Food.FULL).print();

        System.out.println("Select tours by transport (plane):");
        tourList.select(Tour.Transport.PLANE).print();

        System.out.println("Select tours by length (>10):");
        tourList.select(10, true).print();

        System.out.println("Select tours by length (<10):");
        tourList.select(10, false).print();

    }

}
