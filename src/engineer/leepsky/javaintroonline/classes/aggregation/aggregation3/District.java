package engineer.leepsky.javaintroonline.classes.aggregation.aggregation3;

import java.util.Arrays;

public class District extends AdmUnit {

    private City[] cities;
    private int area;

    District(String name, City[] cities, int area, City capital) {

        super(name, capital);
        this.cities = Arrays.copyOf(cities, cities.length);
        this.area = area;

    }

    public int getArea() {
        return area;
    }

}
