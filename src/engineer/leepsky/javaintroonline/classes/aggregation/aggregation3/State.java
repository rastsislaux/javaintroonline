package engineer.leepsky.javaintroonline.classes.aggregation.aggregation3;

import java.util.Arrays;

/* Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
столицу, количество областей, площадь, областные центры. */

public class State extends AdmUnit {

    private Region[] regions;

    State(String name, Region[] regions, City capital) {
        super(name, capital);
        this.regions = Arrays.copyOf(regions, regions.length);
        for (Region region : regions) {
            area += region.getArea();
        }

    }

    public void printRegionsCount() {
        System.out.println(regions.length);
    }

    public void printRegionCapitals() {
        for (Region region : regions) {
            System.out.println(region.getCapitalName());
        }
    }

}
