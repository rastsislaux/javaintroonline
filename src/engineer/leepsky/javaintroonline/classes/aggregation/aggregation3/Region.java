package engineer.leepsky.javaintroonline.classes.aggregation.aggregation3;

import java.util.Arrays;
import java.util.Dictionary;

/* Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
столицу, количество областей, площадь, областные центры. */

public class Region extends AdmUnit {

    private District[] districts;

    Region(String name, District[] districts, City capital) {

        super(name, capital);
        this.districts = Arrays.copyOf(districts, districts.length);
        for (District district : districts) {
            area += district.getArea();
        }

    }

    void printDistrictsCount() {
        System.out.println(districts.length);
    }

}
